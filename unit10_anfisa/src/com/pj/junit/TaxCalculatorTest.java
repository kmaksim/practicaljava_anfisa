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

public class TaxCalculatorTest {

  @Test
  public void test_tax_below_limit() throws Exception {
    int income = 19000;
    TaxCalculator tx = new TaxCalculator();
    int actual=(int) tx.getTaxRate(income);
    System.out.println(actual);
    int expected = income;

    assertEquals(expected, actual);
  }
}

