package guavatest;

import com.google.common.base.Ascii;

/*examples of ASCII methods
 */
public class AsciiTests {

  public static void main(String[] argv) {
    
    System.out.println("GUAVA in lowercase: " + Ascii.toLowerCase("GUAVA"));
    System.out.println("guava in uppercase: " + Ascii.toUpperCase("guava"));
    System.out.println("is 'a' in lowercase? : " + Ascii.isLowerCase('a'));
    System.out.println("is 'A' in UPPERCASE? : " + Ascii.isUpperCase('A'));  
    
  }
}
