package com.pj.homework;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * Multiple files downloader as one archive
 * list URLs to files as command line arguments
 * Usage: MultipleFileDownloaderAsZip <URL to file1> <URL  to fileN>
 * Author: Anfisakho
 */

public class MultipleFileDownloaderAsZip  {

  public static void main(String[] args) {
    
    Vector<String> filesToDownload = new Vector<>();
    if (args.length != 0) {
      filesToDownload= new Vector<String>(Arrays.asList(args)); ;
    } else {
      filesToDownload.add("http://myflex.org/yf/podru/budam421.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam420.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam419.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam418.mp3");
    }

    try (FileOutputStream fout=new FileOutputStream (new File("myArchive.zip"));
        ZipOutputStream zout=new ZipOutputStream(fout);) {
      
      for (String filename : filesToDownload) {
        
        String[] tokens = filename.split("/"); // get file name from URL
       
        URL remoteFile=new URL(filename); 
        URLConnection urlConnFileStream=remoteFile.openConnection();
        
        InputStream in=urlConnFileStream.getInputStream();
        ZipEntry ze=new ZipEntry(tokens[tokens.length - 1]);
        
        System.out.println("Downloading " + tokens[tokens.length - 1]); 
        
        //initialize progress bar settings
        Util.i=0;
        Util.j=0;
        
        try{
          zout.putNextEntry(ze);
          for (int c = in.read(); c != -1 ; c = in.read()) {
              zout.write(c);
              Util.progress();
          }
          
          System.out.println("\nFinished download of " + filename);
         
        } catch (Exception e) { 
          e.printStackTrace();
        }  finally {
          in.close();
        } 
        
      }
      System.out.println("Done.");
    
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    } 
  }
}