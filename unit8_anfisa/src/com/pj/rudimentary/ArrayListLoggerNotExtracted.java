package com.pj.rudimentary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class ArrayListLoggerNotExtracted {

  public static String fileName="Books.txt";
  public static ArrayList<String> bookList = new ArrayList<>();
  static Scanner in;
  static Logger log = Logger.getLogger("ForeachLoopTest"); 
  
  public static void main(String[] args) {
    new ArrayListLoggerNotExtracted().start();
  }
  
  private void start() {
    createLoggerFileHandler();
    log.info("log test");
    getBookNames(fileName);
    System.out.println(bookList);
//    for (String book: BookList) {
//      log.info(book);
//    }
  }
  
  private void getBookNames(String fileName) {
    try {
      log.info("kuku");
      Scanner in = new Scanner(new File(fileName));
      log.info("kuku1");
      while (in.hasNext()) {
        log.info("kuku2");
        String line = in.nextLine(); 
        log.info(line);
        bookList.add(line);
      }
      in.close();
    } catch (IOException ex) {
      ex.printStackTrace();  
      log.info("cant read from file");
    } 
  }
  
  /** configure logger to write to file */
  private void createLoggerFileHandler() {
    FileHandler fh;  
    try {   
        fh = new FileHandler("myLogFile.log");  
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);    
    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    } 
  }
}
