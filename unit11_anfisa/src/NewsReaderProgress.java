import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/*
 * File Reader using Scanner to test SwingWorker
 */
public class NewsReaderProgress extends SwingWorker<String, Integer> {
  String fileContents = "";
  File fileName;
  private static final int DELAY = 2000;
  static int i = 0;
  JTextArea textArea;
  JTextArea textArea1;
  JTextArea textArea2;
  int fsize = 20; // temp file size value

  public NewsReaderProgress(File file, JTextArea textArea) {
    this.fileName = file;
    this.textArea = textArea;

  }

  @Override
  protected String doInBackground() throws Exception {

    if (!fileName.exists() || !fileName.canRead()) {
      System.out.println("Can't read the file");
      return "Can't read the file";
    }
    String line;
    
    int fraction = fsize / 10 ;
    try (Reader ir = new InputStreamReader(new FileInputStream(fileName));
        BufferedReader in = new BufferedReader(ir);) {

      System.out.println("Reading file: " + fileName.getName());
      
      while ((line = in.readLine()) != null) {

        System.out.println("Line: " + line);
        fileContents = fileContents + line + "\n";
        
          i=i+fraction;
          publish(i);
          setProgress(i);
          Thread.sleep(DELAY);
          System.out.println("reading file: " + i); 
          textArea.setText(fileContents);          

      }
    } catch (FileNotFoundException e) {
      System.out.println("File Disappeared");
    }
    return fileContents;
  }
  
  protected void process(String... chunks) {
    //setProgress(i);
    System.out.println("In process: " + i);  
  }

  @Override
  protected void done() {
    if (isCancelled())
      System.out.print("Cancelled !");
    else

      System.out.println("Task done !");
      //setProgress(100);

  }
}