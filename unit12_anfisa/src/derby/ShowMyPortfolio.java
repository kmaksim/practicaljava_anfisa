package derby;
import java.io.IOException;

/*runs the server, gets data from DB and stops the server
 * (run tickers.sql to populate DB with test data) 
 * */

public class ShowMyPortfolio {

  public static void main(String[] args) throws IOException,
      InterruptedException {

    DBS derby = new DBS();

    derby.startServer();
    Thread.sleep(4000);

    Portfolio myPortfolio = new Portfolio();
    Thread t = new Thread(myPortfolio);
    t.start();
    
    Thread.sleep(4000);
    derby.stopServer();

  }
}