
public class ClientThreads1 {

  /**
   * test client in two threads
   * should be used with StockQuoteServerThreads1 started
   * uses Client1 class
   */
  public static void main(String[] args) {
    
    //test array of ports
    int[] ports={3004,4004};
    
    for (int i=0;i<ports.length;i++) {
      Client1 c1 = new Client1(ports[i]);
      Thread c1thread = new Thread(c1);
      c1thread.start();  
    }
  }
}
