package com.pj.rudimentary;

import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import com.pj.util.Utils;;


public class ArrayListPlainText {

  public static String fileName="Books1.txt";
  public static String fileName1="Books2.txt";
  Utils l = new Utils("myLogFile1.log");
  
  public static void main(String[] args) {
    new ArrayListPlainText().start();
  }
  
  private void start() {
    l.log.info("===test start===");
    ArrayList<String> bookList1 = new ArrayList<>();
    bookList1 = l.getPlainTextFileContents(fileName);
    System.out.println(bookList1);
    
  }
}
