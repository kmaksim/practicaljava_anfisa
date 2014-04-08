package com.pj.homework;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Vector;

/**
 * 
 * Multiple files downloader
 * list URLs to files as command line arguments
 * Usage: MultipleFileDownloader <URL to file1> <URL  to fileN>
 * Author: Anfisakho
 */

public class MultipleFileDownloader extends Thread {

  private String filename;

  public MultipleFileDownloader(String filename) {
   this.filename = filename;
  }

  @Override
  public void run() {
    
    String[] tokens = filename.split("/"); // get file name from URL
    
    URL remoteFile = null;
    URLConnection fileStream = null;
    try {
      remoteFile = new URL(filename);
      fileStream = remoteFile.openConnection();
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }         
    
    try (FileOutputStream fOut=new FileOutputStream( tokens[tokens.length -1] );
        InputStream in=fileStream.getInputStream();) {
      
      int data;
      System.out.println("Downloading " + tokens[tokens.length - 1]);
      
      while((data=in.read())!=-1) {
        fOut.write(data); 
        Util.progress(); //prints a dot every Mb
      }

      String workingDir = System.getProperty("user.dir");
      
      System.out.println("\nThe file " + filename +
          " has been downloaded successfully \n at " 
          + workingDir + "/" + tokens[tokens.length - 1] );
    } catch (Exception e) { 
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Vector<String> filesToDownload = new Vector<>();
    if (args.length != 0) {
      filesToDownload= new Vector<String>(Arrays.asList(args)); ;
    } else {
      filesToDownload.add("http://myflex.org/yf/podru/budam421.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam420.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam419.mp3");
    }
    
    for (String filename : filesToDownload) {
      Thread t = new MultipleFileDownloader(filename);
      t.start();
    }
  }
}