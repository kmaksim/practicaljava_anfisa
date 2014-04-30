package JTableTest;

import java.sql.Connection;
import com.google.common.base.Joiner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/*connects to DB Lesson22 and reads data
 * creates Vector data to populate 
 * JTable in DBViewer class
 * */
public class PortfolioDAO implements Runnable {
  String DATABASE_URL;
  String TABLE_NAME;
  
  public Vector rowValues = new Vector();
  public Vector data = new Vector();
  
  public Vector getData() {
    return data;
  }

  public PortfolioDAO(String DATABASE_URL, String TABLE_NAME) {
    this.DATABASE_URL = DATABASE_URL;
    this.TABLE_NAME = TABLE_NAME;
  }

  @Override
  public void run() {

    String sqlQuery = "SELECT * FROM " + TABLE_NAME;
    try (Connection conn = DriverManager.getConnection(DATABASE_URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);) {

      // Process the result set
      while (rs.next()) {
        String symbol = rs.getString("SYMBOL");
        String quantity = rs.getString("QUANTITY");
        double price = rs.getDouble("PRICE");
        double totalPrice = price * Double.valueOf(quantity);

        System.out.println(symbol + " quantity=" + quantity + ", price="
            + totalPrice);
        
        rowValues.addElement(symbol);
        rowValues.addElement(quantity);
        rowValues.addElement(price);
        rowValues.addElement(totalPrice);
        
        System.out.println("rowValues " + Joiner.on(":").join(rowValues));
        
        data.addElement(rowValues);
        rowValues = new Vector();
        
        System.out.println("data: " + Joiner.on(":").join(data));
        
      }
      
      synchronized (RunMe.waitObject) {  
        RunMe.boolValue = true;  
        RunMe.waitObject.notifyAll();  
    }  

    //System.out.println("Thread is finished");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
