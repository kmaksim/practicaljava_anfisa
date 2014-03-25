package com.pj.CollectionTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.pj.util.Utils;

public class PropertiesTest {

  /**
   * Props test
   * todo: test
   * loadFromXML() and storeToXML()
   */
  
  public static void main(String[] args) {
    Utils l = new Utils();
    Properties prop=new Properties();
    FileInputStream in = null;
    try{
      in = new FileInputStream ("mailman.properties");
      prop.load(in);
    } catch(Exception e) {
      e.printStackTrace();
    }
    try {
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String from = prop.getProperty("from");
    String to = prop.getProperty("to");
    String mailServer = prop.getProperty("SmtpServer");
    
    l.log.info("\nfrom:\t\t" + from + 
        "\nto:\t\t" + to +
        " \nmailServer =\t" + mailServer);

  }

}
