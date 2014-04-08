import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

/* Test Server providing YAHOO quotes, NIO test
 * use ClientNIO to test the server
 */

public class StockQuoteServerNIO {
  static ByteBuffer buff = ByteBuffer.allocateDirect(64 * 1024);
  static Charset charset = Charset.forName("8859_1");
  static String incomingMsg;
  public static void main(java.lang.String[] args) throws IOException, InterruptedException {
    
    ServerSocketChannel server = ServerSocketChannel.open( );
    server.configureBlocking(false); // to use non-blocking
    server.socket( ).bind(new InetSocketAddress(5000)); // bind to port
    Selector selector = Selector.open( );
    server.register(selector, SelectionKey.OP_ACCEPT); //register selector
    System.out.println("Registered selector, waiting for a quote request1");
    while (true) {
      System.out.println("Waiting for a quote request1_1");
      selector.select( );
      System.out.println("Waiting for a quote request2");
      Set readyKeys = selector.selectedKeys( );
      System.out.println(readyKeys.toString());
      Iterator iterator = readyKeys.iterator( );
      
      while (iterator.hasNext( )) {
        System.out.println("Waiting for a quote request3");
        SelectionKey key = (SelectionKey) iterator.next( );
        iterator.remove( );
        try {
          if (key.isAcceptable( )) {
            SocketChannel client = server.accept( );
            System.out.println("Accepted connection from " + client);
            client.configureBlocking(false);
            Thread.sleep(4000);
            
            SelectionKey key2 = client.register(selector, SelectionKey.OP_READ );
            
          }
          
          else if (key.isReadable( )) {
            SocketChannel client = (SocketChannel) key.channel( );
            
            if ((client.read(buff) == -1 || buff.get(buff.position() - 1) == '\n')) {
              buff.flip();
              incomingMsg = charset.decode(buff).toString();
              incomingMsg=incomingMsg.replaceAll("(\\r|\\n|\\t)", "");
              System.out.println(">" + incomingMsg + "<");
              
              key.interestOps(SelectionKey.OP_WRITE);
              
              String yahooQuote = getYahooQuote(incomingMsg);
              
              yahooQuote = yahooQuote + "\nEnd\n";

              StringBuffer priceStringBuffer = new StringBuffer(yahooQuote);
              
              ByteBuffer source = ByteBuffer.wrap(String.valueOf(priceStringBuffer).getBytes());
              
              System.out.println("yahooQuote " + yahooQuote);   
              
              SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE );       
              
              key2.attach(source);
              
              //Thread.sleep(20000);
              
            } else {
              key.interestOps(SelectionKey.OP_READ);
            }
                       
          }
          
          else if (key.isWritable( )) {
            SocketChannel client = (SocketChannel) key.channel( );
            ByteBuffer output = (ByteBuffer) key.attachment( );
            if (!output.hasRemaining( )) {
              output.rewind( );
            }
            client.write(output);
          }
        }
        catch (IOException ex) {
          key.cancel( );
          try {
            key.channel().close( );
          }
          catch (IOException cex) {}
        }
      }
    }
  }
  
  
  

  /**
   * Gets qote from Yahoo
   * 
   * @param symbol
   * @return
   */
  public static String getYahooQuote(String symbol) {
    String csvString;
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader inStream = null;
    BufferedReader buff = null;
    String price = null;
    try {
      url = new URL("http://quote.yahoo.com/d/quotes.csv?s=" + symbol
          + "&f=sl1d1t1c1ohgv&e=.csv");
      urlConn = url.openConnection();
      inStream = new InputStreamReader(urlConn.getInputStream());
      buff = new BufferedReader(inStream);

      // get the quote as a csv string
      csvString = buff.readLine();

      // parse the csv string
      // "IBM",191.77,"4/4/2014","4:01pm",-0.92,193.12,193.97,191.28,6090863

      StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
      String ticker = tokenizer.nextToken();
      price = tokenizer.nextToken();
      String tradeDate = tokenizer.nextToken();
      String tradeTime = tokenizer.nextToken();

      System.out.println("Symbol: " + ticker + " Price: " + price + " Date: "
          + tradeDate + " Time: " + tradeTime);
    } catch (MalformedURLException e) {
      System.out.println("Please check the spelling of " + "the URL: "
          + e.toString());
    } catch (IOException e1) {
      System.out.println("Can't read from the Internet: " + e1.toString());
    } finally {
      try {
        inStream.close();
        buff.close();
      } catch (Exception e) {
        System.out.println("StockQuote: can't close streams" + e.getMessage());
      }
    }
    return price;
  }
}
