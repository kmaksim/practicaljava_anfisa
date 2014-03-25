package com.pj.CollectionTests;

import java.util.LinkedList;
import java.util.ListIterator;


import com.pj.util.Utils;

public class LinkedListTest {

  /**
   * LinkedList test -- FIFO
   * question: how to print current class name ?
   * ( i want to add it to logger as a parameter )
   * 
   *  the following will output 
   *  1. uksi
   *  4. nelja
   *  4. nelja
   *  1. uksi
   * 
   */
  public static void main(String[] args) {
    Utils l = new Utils("FIFOTest.log");
    
    LinkedList queue = new LinkedList<String>();
    
    queue.add("1. uksi");
    queue.add("2. kaksi");
    queue.add("3. kolme");
    
    ListIterator myIterator = queue.listIterator();
    l.log.info(myIterator.next().toString());
    
    myIterator.previous();
    myIterator.add("4. nelja");
    myIterator.previous();
    
    l.log.info(myIterator.next().toString());
    myIterator.previous();
    l.log.info(myIterator.next().toString());
    l.log.info(myIterator.next().toString());
    
    System.out.println("queue size = " + queue.size());
    
    
  }

}
