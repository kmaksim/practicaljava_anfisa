package com.pj.homework;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

public class MyCustomizableGUI extends JFrame implements ActionListener {
  JLabel lblName;
  //JTextField txtName = new JTextField(15); 
  
  
  static JTextArea txtName = new JTextArea();

  JButton bOpenPreferences;
  
  
  MyCustomizableGUI() {
    lblName = new JLabel("Enter text to test current colour/font/size settings of JTextArea: ");
    
    txtName.setBounds(3, 3, 100, 20);
    
    //Font font;
    
    upateFieldsData();

    txtName.setText("JTextArea font & color change example");

    bOpenPreferences = new JButton("Open Preferences");
    
    GridLayout gr = new GridLayout(3,1,1,1);
    
    JPanel panel = new JPanel();
    panel.setLayout(gr); 
    
    panel.add(lblName);
    panel.add(txtName);
    panel. add(bOpenPreferences);
    
    //create border 
    TitledBorder titleBorder = BorderFactory.createTitledBorder("My Customized GUI");
    panel.setBorder(titleBorder);
    
    add(panel);

    bOpenPreferences.addActionListener(this);
    
    // Define, instantiate and register a WindowAdapter
    // to process windowClosing Event of this frame

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Good bye!");
  	    System.exit(0);
        }
      });
  }

  public static void upateFieldsData() {
    Font font;
    UserPreferences myPrefs = loadPreferences();
  
    font = new Font(myPrefs.getPropFontLogicalName(), Font.PLAIN, myPrefs.getPropFontSize());
    txtName.setFont(font);
    txtName.setForeground(myPrefs.getPropColour());
  }

  private static UserPreferences loadPreferences() {
    UserPreferences prefs = new UserPreferences();
    FileSystem fileSystem = FileSystems.getDefault();
    Path path = fileSystem.getPath("UserPreferences.ser");
    if(Files.notExists(path)) {
      System.out.println(path + " does not exist. Could not restore.");
      return prefs;
    } else {
      try (FileInputStream fIn = new  FileInputStream("UserPreferences.ser");
          ObjectInputStream oIn = new ObjectInputStream(fIn); ) {
        
        try {
          prefs=(UserPreferences)oIn.readObject();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } finally {
          return prefs;
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        return prefs;
      }
    }
  }

  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    
    if (source == bOpenPreferences ){
      // The Button bOpenPreferences processing
      try{
        PreferencesDialog prefs = new PreferencesDialog(this, "Preferences Dialog", "Test message");
               
       } catch (Exception e){
           e.printStackTrace();
        }
     }    
  }
  
  public static void main(String args[]){
    MyCustomizableGUI myFrame = new MyCustomizableGUI();
  //create border 

    myFrame.setSize(450,150);
    myFrame.setVisible(true);
  }
}
