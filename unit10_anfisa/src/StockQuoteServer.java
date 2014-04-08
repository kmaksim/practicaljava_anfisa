import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

/* Test Server providing YAHOO quotes
 * use with Client class to test the server
 * if client closed the socket Server generates msg below: 
 * Error in Server: java.net.SocketException: Broken pipe
 */

public class StockQuoteServer {
  public static void main(java.lang.String[] args) {
    ServerSocket serverSocket = null;
    Socket client = null;

    BufferedReader inbound = null;
    OutputStream outbound = null;

    try {
      // Create a server socket
      serverSocket = new ServerSocket(3000);

      System.out.println("Waiting for a quote request");
      while (true) {
        // Wait for a request
        client = serverSocket.accept();

        // Get the streams
        inbound = new BufferedReader(new InputStreamReader(
            client.getInputStream()));
        outbound = client.getOutputStream();

        String symbol = inbound.readLine();

        String price = getYahooQuote(symbol);

        outbound.write(("\n The price of " + symbol + " is " + price + "\n")
            .getBytes());

        System.out.println("Request for " + symbol
            + " has been processed - the price of " + symbol + " is " + price
            + "\n");
        outbound.write("End\n".getBytes());
      }
    } catch (IOException ioe) {
      System.out.println("Error in Server: " + ioe);
    } finally {
      try {
        inbound.close();
        outbound.close();
      } catch (Exception e) {
        System.out.println("StockQuoteServer: can't close streams"
            + e.getMessage());
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
