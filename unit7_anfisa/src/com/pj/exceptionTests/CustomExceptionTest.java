package com.pj.exceptionTests;
import java.util.logging.*;

public class CustomExceptionTest {
	
  static Logger log = Logger.getLogger("com.pj.exceptionTess");
  static CustomExceptionTest outer = new CustomExceptionTest();

  class ScaryException extends Exception {
    ScaryException() {
    }
     
    ScaryException(String message) {
      super(message);
      log.info ("Risky method !!!!" + message);
    }
  }
  
  static void doRiskyThing(String test) throws ScaryException {
    log.info ("Risky method begin");
    if ("yes".equals(test)) throw outer.new ScaryException(">>>scary exception<<<");
    log.info ("Risky method end");
  }
  
  public static void main(String[] args) {

	  String test = "yes";

    try {
      doRiskyThing(test);
    } catch (ScaryException e) {
      log.info("Caught " + e + "\n");
      e.printStackTrace();
    }	  
	}
}
