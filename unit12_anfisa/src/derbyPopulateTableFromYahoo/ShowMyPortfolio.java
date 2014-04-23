package derbyPopulateTableFromYahoo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* -runs the server 
 * -populates table, listed in db.properties 
 * of already created lesson22 DB with
 * data from YAHOO
 * -gets data from DB and stops the server
 *  
 *  todo: get rid of timeouts, substitute them with threads join
 * */

public class ShowMyPortfolio {
  public final static Object waitObject = ShowMyPortfolio.class;
  public static boolean boolValue = false;
  
  public static void main(String[] args) throws IOException,
      InterruptedException {
    
    DBS dbs = new DBS();

    dbs.startServer();
    Thread.sleep(4000);

    dbs.createTable();

    Hashtable<String, Integer> tickers = new Hashtable();
    tickers.put("EPAM", 50);
    tickers.put("LXFT", 40);
    tickers.put("AAPL", 100);
    tickers.put("IBM", 20);
    tickers.put("GOOG", 120);
    tickers.put("A", 120);
    
    dbs.populateTable(tickers);

    Thread.sleep(4000);

    Portfolio myPortfolio = new Portfolio(dbs.DATABASE_URL, dbs.TABLE_NAME);
    Thread t = new Thread(myPortfolio);
    t.start();
        
    
    try {  
      synchronized (ShowMyPortfolio.waitObject) {  
          while (!ShowMyPortfolio.boolValue) {  
            ShowMyPortfolio.waitObject.wait();  
          }  
      }  
    } catch (InterruptedException ie) {  
      ie.printStackTrace();  
    }  
    
    dbs.cleanup();
    
    dbs.stopServer();

  }
}