package com.pj.junit;

public class TaxCalculator {

  double getTaxRate(double income) {
    if (income < 20000) {
      return income;
    } else {
      return income*0.005;
    }
  }

  double getTaxRate(double income , String state) {
    StateTaxCalculator stc = new StateTaxCalculator();
    return income*0.005*Float.parseFloat(stc.stateFactor.get(state));
  }
  
}
