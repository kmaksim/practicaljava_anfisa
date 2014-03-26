package com.pj.ParameterizedClasses;

public class BookStore<T> {
  T bookType;
  
  public void add(T bookType) {
    this.bookType = bookType;
    System.out.print("Added to the store: " + bookType.toString() + "\n");
  }
  
  public T sell() {
    System.out.print("Sold: " + bookType.toString() + "\n");
    return bookType;
  }
}
