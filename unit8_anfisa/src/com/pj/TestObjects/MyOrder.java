package com.pj.TestObjects;

public class MyOrder {
  private int quantity;
  private String customer;

  public MyOrder(int i, String customer) {
    this.quantity = quantity;
    this.customer = customer; 
  }

  @Override
  public String toString() {
    return "MyOrder [quantity=" + quantity + ", customer=" + customer + "]";
  }

}
