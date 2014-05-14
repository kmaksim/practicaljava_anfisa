package StockServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class StockServer  {
  public String symbol;
  
  public StockServer(String symbol) {
    this.symbol = symbol;
  }


  /**
   * Gets quote from Yahoo
   * 
   * @param symbol
   * @return
   */
  public static String getYahooQuote(String symbol)  {
    String csvString;
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader inStream = null;
    BufferedReader buff = null;
    String price = null;


    // uncomment the following code to test timeout
//        try {
//          Thread.sleep(50000);
//        } catch (InterruptedException e2) {
//          e2.printStackTrace();
//        }
    
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

      System.out.println("Reply from YAHOO: Symbol: " + ticker + " Price: " + price + " Date: "
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


