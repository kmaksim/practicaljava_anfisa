package com.pj.TestObjects;

public class MyBook {

  /**
   * Book object
   */
  String bookName;
  String bookAuthor;
  
  public MyBook(String bookName, String bookAuthor) {
    this.bookName = bookName;
    this.bookAuthor = bookAuthor;
  }
  
  public String getBookName() {
    return this.bookName;
  }
  
  public String getBookAuthor() {
    return this.bookAuthor;
  }

  @Override
  public String toString() {
    return "MyBook [bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
  }
  
  
}
