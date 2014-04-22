package derby;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*starts and stops DB server with params from derby.properties*/
public class DBS {

  public static String db_path;
  public static String startupCmd;
  public static String stopCmd;
  public static String envVar;

  public DBS() {

    Properties prop = new Properties();
    //try with resources
    try ( FileInputStream in = new FileInputStream("derby.properties");) {
      prop.load(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    this.startupCmd = prop.getProperty("startupCmd");
    this.stopCmd = prop.getProperty("stopCmd");
    this.envVar = prop.getProperty("envVar");
  }

  public static void startServer() throws IOException {
    String[] envp = new String[] { envVar };
    
    Runtime.getRuntime().exec(startupCmd, envp);
  }

  public static void stopServer() throws IOException {
    String[] envp = new String[] { envVar };

    Runtime.getRuntime().exec(stopCmd, envp);
  }

}