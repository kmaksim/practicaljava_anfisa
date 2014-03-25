package com.pj.CollectionTests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

import com.pj.util.Utils;

public class QueueTest {

  /**
   * Queue test -- FIFO
   * question: how to print current class name ?
   * ( i want to add it to logger as a parameter )
   */
  public static void main(String[] args) {
    Utils l = new Utils("FIFOTest.log");
    Queue<String> queue = new LinkedList<String>();
    queue.add("1. uksi");
    queue.add("2. kaksi");
    queue.add("3. kolme");
    
    l.log.info("queue size = " + queue.size());
    
    l.log.info(queue.remove().toString());
    l.log.info(queue.remove().toString());
    l.log.info(queue.remove().toString());

    System.out.println("queue size = " + queue.size());
    
    queue.add("1. uksi");
    queue.add("2. kaksi");
    queue.add("3. kolme");
    
    
    System.out.println("queue size = " + queue.size());
    
  }

}
