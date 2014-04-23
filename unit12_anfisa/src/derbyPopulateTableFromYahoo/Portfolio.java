package derbyPopulateTableFromYahoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*connects to DB Lesson22 and reads data*/
public class Portfolio implements Runnable {
  String DATABASE_URL;
  String TABLE_NAME;

  public Portfolio(String DATABASE_URL, String TABLE_NAME) {
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
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
