package com.pj.CollectionTests;

  import java.util.ArrayList;
  import java.util.Collections;
  import com.pj.util.Utils;

  public class ArrayListTests {
  /** it does not yet display strings in UTF 8, but at least reads the file in UTF - 8 */
    
    public static String fileName="Books.txt";
    public static String fileName1="Books1.txt";
    
    Utils l = new Utils("myLogFile2.log");
    
    public static void main(String[] args) {
      new ArrayListTests().start();
    }
    
    private void start() {

      /*
       * the code below will cause
       * Exception in thread "main" java.lang.NullPointerException
  at com.pj.CollectionTests.ArrayListTests.start(ArrayListTests.java:22)
  at com.pj.CollectionTests.ArrayListTests.main(ArrayListTests.java:16)
  
      ArrayList<String> al = null;
      al.add("testStr");
      System.out.println(al.toString());
      
      */
      
      ArrayList<String> bookList = new ArrayList<>();
      ArrayList<String> bookList1 = new ArrayList<>();
      l.log.info("===test start===");
      /** fill bookLits and bookList 1 with contents from text files */
      bookList = l.getUTF8TextFileContents(fileName);
      bookList1 = l.getPlainTextFileContents(fileName1);
      System.out.println("not sorted:" + bookList);
      
      /** test add method */
      bookList.add("test book title");
      System.out.println("added element" + bookList);
      
      /** sorting Array List */
      Collections.sort(bookList);
      System.out.println("sorted" + bookList);
      
      /** add bookList1 to bookList ( seems like appending ) */
      bookList.addAll(bookList1);
      System.out.println("Added booList1:" + bookList);
      String[] bookArray = new String[bookList.size()];
      bookArray = (String[]) bookList.toArray();
      //System.out.println("Array:" + bookArray);
      
      /**clear the list*/
      bookList.clear();
      if (bookList.isEmpty()) {
        l.log.info("booklist size:" + bookList.size());
      }   
    }
  }



