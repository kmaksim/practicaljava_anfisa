package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*connects to DB Lesson22 and reads data*/ 
public class Portfolio implements Runnable {

  @Override
  public void run() {
    
    String sqlQuery = "SELECT * FROM PORTFOLIO";
    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
        ) {
   
      //Process the result set
      while(rs.next()){
        String symbol = rs.getString("SYMBOL");
        String quantity = rs.getString("QUANTITY");
        double price = rs.getDouble("PRICE");
        double totalPrice = price * Double.valueOf(quantity);
        System.out.println(symbol + " quantity=" + quantity +
            " price=" + totalPrice);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
