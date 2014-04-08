package com.pj.junit;

import java.util.HashMap;
import java.util.Map;

public class StateTaxCalculator {

   Map<String , String > stateFactor;

   public StateTaxCalculator() {

    stateFactor = new HashMap<String, String>();
    stateFactor.put("texas", "1.5");
    stateFactor.put("florida", "1.2");
    stateFactor.put("new york", "2");
    
    for (String state: stateFactor.keySet())
      System.out.println(state);  

  }
}
