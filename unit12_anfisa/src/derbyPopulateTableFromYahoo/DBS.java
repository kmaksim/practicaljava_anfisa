package derbyPopulateTableFromYahoo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;

/* starts and stops DB server with params from derby.properties
 * clears up the DB and populates it with updated DATA from Yahoo server*/
public class DBS {

  public static String DB_PATH;
  public static String STARTUP_CMD;
  public static String STOP_CMD;
  public static String ENV_VAR;
  public static String DRIVER;
  public static String DATABASE_URL;
  public static String TABLE_NAME;

  public DBS() {

    Properties prop = new Properties();
    // try with resources
    try (FileInputStream in = new FileInputStream("db.properties");) {
      prop.load(in);
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.STARTUP_CMD = prop.getProperty("STARTUP_CMD");
    this.STOP_CMD = prop.getProperty("STOP_CMD");
    this.ENV_VAR = prop.getProperty("ENV_VAR");
    this.DRIVER = prop.getProperty("DRIVER");
    this.DATABASE_URL = prop.getProperty("DATABASE_URL");
    this.TABLE_NAME = prop.getProperty("TABLE_NAME"); 
  }

  public static void startServer() throws IOException {
    String[] envp = new String[] { ENV_VAR };

    Runtime.getRuntime().exec(STARTUP_CMD, envp);
  }

  public static void stopServer() throws IOException {
    String[] envp = new String[] { ENV_VAR };

    Runtime.getRuntime().exec(STOP_CMD, envp);
  }

  public boolean createTable() {

    boolean result = false;
    String createTableCmd = "CREATE TABLE " 
        + TABLE_NAME
        + " (id INTEGER NOT NULL, " 
        + "symbol VARCHAR(10) NOT NULL, "
        + "quantity INTEGER NOT NULL, " 
        + "price FLOAT NOT NULL,"
        + "PRIMARY KEY (id) )";

    try (Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();) {
      // load the driver class
      Class.forName(DRIVER);

      //statement.executeUpdate("DROP TABLE " + TABLE_NAME);
      statement.executeUpdate(createTableCmd);
      
      result = true;

    } catch (SQLException e) {
      e.getMessage();

    } catch (ClassNotFoundException e) {
      e.getMessage();
    }

    return result;
  }

  public boolean populateTable(Hashtable<String, Integer> tickers) {
    boolean result = false;

    try (Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();) {
      // load the driver class
      Class.forName(DRIVER);

      // populate the table
      PreparedStatement pstmt = connection
          .prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?)");

      int id = 0;
      for (String ticker : tickers.keySet()) {

        //System.out.println(ticker);
        //System.out.println((Integer) tickers.get(ticker));

        pstmt.setInt(1, id);
        pstmt.setString(2, ticker); // symbol
        pstmt.setInt(3, (Integer) tickers.get(ticker)); // quantity
        pstmt.setFloat(4, Float.parseFloat(Util.getYahooQuote(ticker))); // price
        pstmt.executeUpdate();

        id++;
      }
      result = true;
      
    } catch (SQLException e) {
      e.getMessage();

    } catch (ClassNotFoundException e) {
      e.getMessage();
    }
    return result;
  }

  public boolean cleanup() {
    
    boolean result = false;
    
    try (Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();) {
      // load the driver class
      Class.forName(DRIVER);

      statement.executeUpdate("DROP TABLE " + TABLE_NAME);
      
      result = true;

    } catch (SQLException e) {
      e.getMessage();

    } catch (ClassNotFoundException e) {
      e.getMessage();
    }  
    
    return result;
  }
}