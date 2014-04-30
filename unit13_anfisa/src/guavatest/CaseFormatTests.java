package guavatest;

import com.google.common.base.CaseFormat;

/*CaseFormat tests
 */
public class CaseFormatTests {
  
  public static void main(String[] argv) {
    
    System.out.println("was: THIS_IS_A_TEST, converted to: " 
    + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,"THIS_IS_A_TEST"));
    
    System.out.println("was: this-is-a-test, converted to: " 
        + CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,"this-is-a-test"));
    
    System.out.println("was: this_is_a_test, converted to: " 
    + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,"this_is_a_test"));
    
    System.out.println("was: thisIsATest, converted to: " 
    + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,"thisIsATest"));
    
  }
}
