package com.pj.rudimentary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import com.pj.util.Utils;;


public class Backup1_ArrayListPlainText {

  public static String fileName="Books1.txt";
  public static String fileName1="Books2.txt";
  Utils l = new Utils("myLogFile1.log");
  
  public static void main(String[] args) {
    new Backup1_ArrayListPlainText().start();
  }
  
  private void start() {
    l.log.info("===test start===");
    ArrayList<String> bookList1 = new ArrayList<>();
    bookList1 = getPlainTextFileContents(fileName);
    System.out.println(bookList1);
    
  }
  
  private ArrayList<String> getPlainTextFileContents(String fileName) {
    ArrayList<String> alist = new ArrayList<>();
    try {
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNext()) {
        String line = in.nextLine(); 
        l.log.info(line);
        alist.add(line);
      }
      in.close();
    } catch (IOException ex) {
      ex.printStackTrace();
      l.log.info("cant read from file");
    }
    return alist; 
  }
}
