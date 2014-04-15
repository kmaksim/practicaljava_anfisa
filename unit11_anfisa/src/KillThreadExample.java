
public class KillThreadExample {

  public static void main(String args[]){
    Portfolio p = new Portfolio();
    p.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //we will stop the p thread in about 1000ms
    p.stopMe();
  }
}

class Portfolio extends Thread {
  //volatile is for thread to take the latest not cashed value
  private volatile Boolean stopMe;
  
  public Portfolio() {
    stopMe = false;
  }

  public void stopMe() {
    System.out.println("setting stop flag to true, hopefully we will stop the thread!");
    stopMe = true;
  }

  @Override
  public void run() {
    
    System.out.println("I'm in run method");
      while (stopMe == false) {
        
        System.out.println("stopMe=" + stopMe);
      }
      System.out.println("stopMe=" + stopMe);
  }
}