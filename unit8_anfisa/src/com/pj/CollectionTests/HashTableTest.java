package com.pj.CollectionTests;

  import java.util.HashMap;

import com.pj.TestObjects.MyBook;
import com.pj.TestObjects.MyOrder;
import com.pj.TestObjects.MyRank;
import com.pj.util.Utils;

  /**misprint in the book -- 
   * "The class HashMap is similar to Hashtable, but it allows null 
   * as a key or value and is not synchronized." 
   * seems like it is the other way around
   */

  public class HashTableTest {
  
  public static void main(String[] args) {
      
    Utils l = new Utils();
    
    MyBook book1 = new MyBook("Book name", "Book author");
    MyOrder ord = new MyOrder(123, "IBM");
    MyRank rank = new MyRank(123);
    
    HashMap data = new HashMap();
    data.put("Book", book1);
    data.put("Order", ord);
    data.put("Rank", rank);
    data.put(null, rank);
    data.put("Rank1", null);
      
    l.log.info(data.toString());   
      
    }
  }