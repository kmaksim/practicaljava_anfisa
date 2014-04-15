
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Multiple files downloader with Executor/Callable
 * list URLs to files as command line arguments
 * Usage: MultipleFileDownloader <URL to file1> <URL  to fileN>
 */

public class MultipleFileDownloaderCallable {
 

  public static void main(String[] args) {
    
    Vector<String> filesToDownload = new Vector<>();
    
    if (args.length != 0) {
      filesToDownload= new Vector<String>(Arrays.asList(args)); ;
    } else {
      filesToDownload.add("http://myflex.org/yf/podru/budam421.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam420.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam419.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam418.mp3");
      filesToDownload.add("http://myflex.org/yf/podru/budam417.mp3");
    }
    
    //ExecutorService threadExecutor = Executors.newCachedThreadPool();
    ExecutorService threadExecutor = Executors.newScheduledThreadPool(3);
    
    ArrayList<FileDownloader> tasks = new ArrayList();
    
    for (String filename : filesToDownload) {
      tasks.add(new FileDownloader(filename));
    }
    
    for (FileDownloader task : tasks  ) {
      threadExecutor.submit(task); // start task
    }
    
    threadExecutor.shutdown(); 

    System.out.println( "Tasks started.\n" );
    
  }
}



class FileDownloader implements Callable {
  private String filename;

  public FileDownloader(String filename) {
   this.filename = filename;
  }


  @Override
  public Object call() throws Exception {
    
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
    
    return null;
  }

}
