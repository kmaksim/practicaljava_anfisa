

public class Util {

  static double i=0;
  static double j=0;
   
  /**
   * Progress bar, illustrates progress with dots
   */
  
  public static void progress() {
    i++;
    //prints a dot every Mb 
    if ( (i % (1024*1024)) == 0 ) {
      j++;
      System.out.print(".");
      //new line every 64 Mb
      if (j==64) {
        System.out.println("");
        j=0;
      }
    }
  }
}




