package com.pj.TestGenericMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.pj.TestObjects.MyAniqueBook;
import com.pj.TestObjects.MyBook;
import com.pj.util.Utils;

/** 
 * Question: how come i add  MyAniqueBook (3 fields) to List Object<Book> (2 fields)
 * and i still have MyAniqueBook in the List
 * 
 */

public class TestGenericMethod {
  static Utils l = new Utils("TestGenericMethod.txt");
  
  public static void main(String args []) {
    
    TestGenericMethod gm = new TestGenericMethod();
    
    MyAniqueBook abook1 = new MyAniqueBook("bookName1","Author1","Some pages are teared out and lost");
    MyAniqueBook abook2 = new MyAniqueBook("bookName2","Author2","Dusty");
    ArrayList<MyAniqueBook> abl = new ArrayList<MyAniqueBook>();
    abl.add(abook1);
    abl.add(abook2);
    
    gm.TestGenericMethod(abl);
    
    l.log.info("Antique books list contents:\n" + abl.toString()) ;
  }
  
  public void TestGenericMethod (ArrayList<?> al) {
    List<MyBook> lst = new ArrayList<MyBook>();
    lst.addAll((Collection<? extends MyBook>) al);
    
    Iterator iterator = lst.iterator();
    
    MyBook tempBook = new MyBook(null, null);
    
    while (iterator.hasNext()) {
      tempBook = (MyBook) iterator.next();
      l.log.info("\nBook name: " + tempBook.getBookName());
    }
    
    l.log.info("List contents:\n" + lst.toString()) ;
  }
}
