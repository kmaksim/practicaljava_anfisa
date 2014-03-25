package com.pj.CollectionTests;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pj.TestObjects.MyBook;
import com.pj.util.Utils; 

public class ListTests {

  /**
   * List tests, list allows multiple occurrences of elements
   * questions: can we sort list?
   */
  
  public static void main(String[] args) {
    Utils l = new Utils("listTests.log");
    List testList = new ArrayList();
    MyBook book1 = new MyBook ("name1","author1") ;
    testList.add(book1);
    testList.add(1);
    testList.add(1);
    testList.add(1);
    testList.add("just a string");
    testList.add("just a string");
    testList.add("just a string");
    
    /** output list*/
    l.log.info(testList.toString());
    
    /** get list element by index */
    l.log.info("the second element is: " + testList.get(1).toString());
    
    /**iterating over lists */
    for (Iterator iterator = testList.iterator(); iterator.hasNext(); ) {
      String element = iterator.next().toString();
      System.out.println(element);
    }
    
    /** another shortcut to iterate, but it is converted to the above verion by the compiler */
    for (Object o:testList) {
      System.out.println(o.toString());
    }   
  }
}
