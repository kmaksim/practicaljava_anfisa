package com.pj.CollectionTests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pj.TestObjects.MyBook;
import com.pj.util.Utils; 

public class SetTests {

  /**
   * Set tests, list allows multiple occurances of elemts
   * no duplicates in HashSet
   * other sets are TreeSet and LinkedHashSet, slower then hashSet
   */
  
  public static void main(String[] args) {
    Utils l = new Utils("listTests.log");
    HashSet testSet = new HashSet();
    MyBook book1 = new MyBook ("name1","author1") ;
    testSet.add(book1);
    testSet.add(1);
    testSet.add(1);
    testSet.add(1);
    testSet.add("just a string");
    testSet.add("just a string");
    testSet.add("just a string");
    testSet.add(null);
    
    l.log.info(testSet.toString());
    
    ArrayList<String> bookList = new ArrayList<>();
    bookList = l.getPlainTextFileContents("Books1.txt");
    l.log.info("ArrayList: " + bookList.toString());
    
    HashSet setFromList = new HashSet(bookList);
    l.log.info("HashSet from ArrayList: " +setFromList.toString());
    
    
  }
}
