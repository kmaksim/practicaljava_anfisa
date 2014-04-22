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
public class NewsReader2 extends SwingWorker<String, Integer> {
  String fileContents = "";
  File fileName;
  private static final int DELAY = 1000;

  public NewsReader2(File file) {
    this.fileName = file;
  }

  @Override
  protected String doInBackground() throws Exception {

    if (!fileName.exists() || !fileName.canRead()) {
      System.out.println("Can't read the file");
      return "Can't read the file";
    }
    String line;
    try (Reader ir = new InputStreamReader(new FileInputStream(fileName));
        BufferedReader in = new BufferedReader(ir);) {

      System.out.println("Reading file: " + fileName.getName());

      while ((line = in.readLine()) != null) {

        System.out.println("Line: " + line);
        fileContents = fileContents + line + "\n";
        Thread.currentThread().sleep(DELAY);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File Disappeared");
    }
    return fileContents;
  }

  @Override
  protected void done() {
    if (isCancelled())
      System.out.print("Cancelled !");
    else
      // SwingWorkerTest.textArea1.append("Done !");
      

      System.out.println("Task done !");

  }
}