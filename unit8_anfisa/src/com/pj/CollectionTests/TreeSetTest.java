package com.pj.CollectionTests;
import java.util.*;

public class TreeSetTest {
  /** the following code will produce an error since there is comparable in Book*/
  /** I need to make it by hand */
  
   public static void main (String[] args) {
   
     Book b1 = new Book("How Cats Work");
     Book b2 = new Book("Remix your Body");
     Book b3 = new Book("Finding Emo");

     TreeSet<Book> tree = new TreeSet<Book>();
     tree.add(b1);
     tree.add(b2);
     tree.add(b3);
     System.out.println(tree);
   }
}

class Book {
   String title;
   public Book(String t) {
     title = t;
   }
  }
