package guavatest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.io.Files;

public class FileTests {
  public static void main(String[] args) {
    
    final String curDir = System.getProperty("user.dir");
    
    /*test file copy from current diectory*/
    
    File source  = new File("db.properties");
    File copyDestination = new File("db2.properties");
    try {
      Files.copy(source, copyDestination);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    listDir(curDir);
    
    /*test file move from current diectory*/
    
    File moveDestination = new File("Moved_db1.properties");
    try{
        Files.move(copyDestination, moveDestination);
    }catch (IOException e){
        e.printStackTrace();
    }
    
    listDir(curDir);
    
  }
  
  public static String listDir(String dirName) {
    File myDir = new File(dirName);
    if ( myDir.isDirectory()) {
      String[] files=myDir.list();
      List<String> filesList= Arrays.asList(files); 
      Collections.sort(filesList);

      System.out.println(dirName + " "+ filesList.toString());
      
      return filesList.toString();
    } else {
      return "can't read a dir";
    } 
  }

}
