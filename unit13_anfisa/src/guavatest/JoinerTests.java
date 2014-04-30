package guavatest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

/* Joiner tests*/

public class JoinerTests {
  
  public static void main(String[] argv) {
    
    //sample List to join:
    List<String> tickers = new ArrayList();
    tickers.add("EPAM");
    tickers.add("LXFT");
    tickers.add("AAPL");
    tickers.add("IBM");
    tickers.add(null);
    tickers.add("GOOG");
    tickers.add("A");
    
    /*example of Joiner usage: 
     */
    
    System.out.println(Joiner.on("|").skipNulls().join(tickers));
    
    /* usage of stringBuilder class and joiner*/
    
    StringBuilder stringBuilder = new StringBuilder();
    Joiner joiner = Joiner.on("").skipNulls();
    
    System.out.println( joiner.appendTo(stringBuilder,"EPAM","LXFT","AAPL"));
    
    /*example of Map joiner*/
    
    Hashtable<String, Integer> tickersHash = new Hashtable();
    tickersHash.put("EPAM", 50);
    tickersHash.put("LXFT", 40);
    tickersHash.put("AAPL", 100);
    tickersHash.put("IBM", 20);
    tickersHash.put("GOOG", 120);
    tickersHash.put("A", 120);  
    
    MapJoiner mapJoiner = Joiner.on(":").withKeyValueSeparator("=");
    
    System.out.println(mapJoiner.join(tickersHash));
    
  }
}
