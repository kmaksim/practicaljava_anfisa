
public class StockQuoteServerThreads1 {

  /**
   * Test of two servers started in two different threads
   * on 2 ports
   */
  public static void main(String[] args) {
    StockQuoteServer1 server1 = new StockQuoteServer1(3004);
    Thread server1thread = new Thread(server1);
    server1thread.start();
    StockQuoteServer1 server2 = new StockQuoteServer1(4004);
    Thread server2thread = new Thread(server2);
    server2thread.start();
    

  }

}
