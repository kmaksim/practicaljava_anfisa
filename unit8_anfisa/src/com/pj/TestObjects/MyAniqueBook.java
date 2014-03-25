package com.pj.TestObjects;

public class MyAniqueBook extends MyBook {

  private String condition;

  /**
   * Antique Book object
   */
  
  
  public MyAniqueBook(String bookName, String bookAuthor, String condition) {
    super(bookName, bookAuthor);
    this.condition = condition;
  }
  
  public String getCondition() {
    return condition;
  }

  @Override
  public String toString() {
    return "MyAniqueBook [condition=" + condition + ", bookName=" + bookName
        + ", bookAuthor=" + bookAuthor + "]";
  }

 
  
  
}
