package com.pj.homework;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0

public class MultipleFileDownloader extends Thread {

  private String filename;

  public MultipleFileDownloader(String filename) {
   this.filename = filename;
  }

  @Override
  public void run() {
    
    InputStream in=null; 
    FileOutputStream fOut=null;
    try{
      URL remoteFile=new URL(filename);      
      URLConnection fileStream=remoteFile.openConnection();
      
      // Open output and input streams 
      String[] tokens = filename.split("/"); // get file name from URL
      fOut=new FileOutputStream( tokens[tokens.length -1] ); 
      in=fileStream.getInputStream();
    
      int data;
      System.out.println("Downloading " + tokens[tokens.length - 1]);
      double i=0;
      double j=0;
      while((data=in.read())!=-1) {
        fOut.write(data);
        i++;
        if ( (i % 1000000) == 0 ) {
          j++;
          if (j==63) {
            System.out.println(".");
          }
          System.out.print(".");
        }
      }

      String workingDir = System.getProperty("user.dir");
      
      System.out.println("\nThe file " + filename +
          " has been downloaded successfully \n at " 
          + workingDir + "/" + tokens[tokens.length - 1] );
    } catch (Exception e) { 
      e.printStackTrace();
    } finally{
      try{ 
        in.close(); 
        fOut.flush(); 
        fOut.close();
      } catch(Exception e) {
        e.printStackTrace(); 
      }
    }
    
    
  }

  public static void main(String[] args) {
    for (String filename : args) {
      Thread t = new MultipleFileDownloader(filename);
      t.start();
    }
  }
}