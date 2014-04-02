package com.pj.CollectionTests;

  import java.util.Hashtable;

import com.pj.TestObjects.MyBook;
import com.pj.TestObjects.MyOrder;
import com.pj.TestObjects.MyRank;
import com.pj.util.Utils;

  public class HashTableTest {
  
  public static void main(String[] args) {
      
    Utils l = new Utils();
    
    MyBook book1 = new MyBook("Book name", "Book author");
    MyOrder ord = new MyOrder(123, "IBM");
    MyRank rank = new MyRank(123);
    
    Hashtable data = new Hashtable();
    data.put("Book", book1);
    data.put("Order", ord);
    data.put("Rank", rank);
    
    /** error if to try to put the following elemts into HashMap */
    //data.put(null, rank);
    //data.put("Rank1", null);
      
    l.log.info(data.toString());   
      
    }
  }