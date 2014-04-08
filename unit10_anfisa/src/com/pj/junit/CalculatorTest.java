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

public class CalculatorTest {

  @Test
  public void test_sum() throws Exception {
      int expected = 1+2;
      assertEquals(expected, new Calculator().add(1, 2));
  }
}

