package com.pj.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utils {

  public Logger log = Logger.getLogger("unit8"); 
  
  public Utils() {
    createLogger();
  }
  
  private void createLogger() {
    // 
  }

  public Utils(String fileName) {
    createLoggerFileHandler(fileName); 
  }
  
  /** configure logger to write to file */
  private void createLoggerFileHandler(String fileName) {
    FileHandler fh;  
    try {   
        fh = new FileHandler(fileName);  
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);    
    } catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    } 
  }

  /** read plain text file and return ArrayList */
  public ArrayList<String> getPlainTextFileContents(String fileName) {
    ArrayList<String> alist = new ArrayList<>();
    try {
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNext()) {
        String line = in.nextLine(); 
        //log.info(line);
        alist.add(line);
      }
      in.close();
    } catch (IOException ex) {
      ex.printStackTrace();
      log.info("cant read from file");
    }
    return alist; 
  }

  /** read UTF8 file and return plain text*/
  //public ArrayList<String> getUTF8TextFileContents(ArrayListUTF8 arrayListUTF8, String fileName) {
  public ArrayList<String> getUTF8TextFileContents(String fileName) {  
    ArrayList<String> alist = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line;
      while(  (line = reader.readLine()) != null) { 
        String lineUTF8 = new String(line.getBytes(),"UTF-8");
        //l.log.info( lineUTF8);
        alist.add(lineUTF8);
      }
      reader.close();
    } catch (IOException ex) {
      ex.printStackTrace(); 
      log.info("cant read from file");
    }
    return alist; 
  }
}




