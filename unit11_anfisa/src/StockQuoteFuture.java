import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * YAHOO StockQuote data downloader using Future/Callable
 * tickets list is hard-coded in String tickers[] array
 */

public class StockQuoteFuture {

  public static void main(String args[]) throws InterruptedException,
      ExecutionException {

    List<Future<String>> futures = new ArrayList();
    List<String> results = new ArrayList();

    // varying the number of threads in newFixedThreadPool we
    // could observe how threads are working
    // for example, if we chose 2, we'll see that results
    // are downloaded in pairs
    // and if we choose 1, the process will be noticeably slower
    final ExecutorService te = Executors.newFixedThreadPool(4);

    String tickers[] = { "EPAM", "LXFT", "AAPL", "IBM", "GOOG" };
    try {
      for (int i = 0; i < tickers.length; i++) {
        futures.add(te.submit(new StockQuoteReader(tickers[i])));
      }
      for (Future<String> future : futures) {
        results.add(future.get());
      }
    } finally {
      te.shutdown();
    }

    for (String res : results) {
      System.out.println("Result: " + res);
    }

  }
}

class StockQuoteReader implements Callable {

  private String symbol;

  public StockQuoteReader(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String call() throws Exception {
    String csvString;
    URL url = null;
    URLConnection urlConn = null;
    InputStreamReader inStream = null;
    BufferedReader buff = null;
    String result = null;

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
      String price = tokenizer.nextToken();
      String tradeDate = tokenizer.nextToken();
      String tradeTime = tokenizer.nextToken();

      result = "Symbol: " + ticker + " Price: " + price + " Date: " + tradeDate
          + " Time: " + tradeTime;
      System.out.println("Callable speaking: Symbol: " + ticker + " Price: "
          + price + " Date: " + tradeDate + " Time: " + tradeTime);
      return result;

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
      // return "failed";
    }
    return result;
  }
}
