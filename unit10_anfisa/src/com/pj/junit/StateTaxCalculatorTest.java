/**
 * 
 */
package com.pj.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StateTaxCalculatorTest {

  @Test
  public void test_correct_stateFactor_values() throws Exception {
      String expected = "1.2";
      assertEquals(expected, new StateTaxCalculator().stateFactor.get("florida"));
  }
}

