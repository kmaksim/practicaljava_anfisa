package JTableTest;


import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* Shows Portfolio data in log and JTable
 *  
 * -runs the server 
 * -populates table, listed in db.properties, creates DB if there is no DB yet 
 * of already created lesson22 DB with
 * data from YAHOO
 * -opens JTable with data
 * -gets data from DB and stops the server
 *  
 *  todo: add check that derbi is started
 * */

public class RunMe {
  public final static Object waitObject = RunMe.class;
  public static boolean boolValue = false;
  
  public static void main(String[] args) throws IOException,
      InterruptedException {
    
    DBSUtils dBSUtils = new DBSUtils();

    dBSUtils.startServer();

    dBSUtils.createTable();

    Hashtable<String, Integer> tickers = new Hashtable();
    tickers.put("EPAM", 50);
    tickers.put("LXFT", 40);
    tickers.put("AAPL", 100);
    tickers.put("IBM", 20);
    tickers.put("GOOG", 120);
    tickers.put("A", 120);
    
    
    while (!dBSUtils.populateTable(tickers)) {
      Thread.sleep(1000);
    }

    PortfolioDAO myPortfolio = new PortfolioDAO(dBSUtils.DATABASE_URL, dBSUtils.TABLE_NAME);
    Thread t = new Thread(myPortfolio);
    t.start();
        
    
    try {  
      synchronized (RunMe.waitObject) {  
          while (!RunMe.boolValue) {  
            RunMe.waitObject.wait();  
          }  
      }  
    } catch (InterruptedException ie) {  
      ie.printStackTrace();  
    }  
    
    DBViewer frame = new DBViewer(myPortfolio.getData());
    
    frame.pack();
    frame.setVisible(true);
    
    dBSUtils.cleanup();
    
    dBSUtils.stopServer();

  }
}