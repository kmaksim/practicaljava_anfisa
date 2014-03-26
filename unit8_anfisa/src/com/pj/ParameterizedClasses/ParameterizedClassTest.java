package com.pj.ParameterizedClasses;

import com.pj.TestObjects.MyAniqueBook;
import com.pj.TestObjects.MyBook;

public class ParameterizedClassTest {
  
  public static void main(String argv[]) {
    MyAniqueBook abook1 = new MyAniqueBook("bookName1","Author1","Some pages are teared out and lost");
    MyBook book1 = new MyBook("bookName2","Author2");
    
    BookStore<MyAniqueBook> antiqueBookStore = new BookStore<>();
    antiqueBookStore.add(abook1);
    antiqueBookStore.sell();
    
    BookStore<MyBook> bookStore = new BookStore<>();
    bookStore.add(book1);
    bookStore.sell();
    
  }

}
