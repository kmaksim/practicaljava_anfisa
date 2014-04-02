package com.pj.homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class PreferencesDialog extends JDialog implements ActionListener   {
  JComboBox comboColour;
  private JComboBox comboFont;
  private JComboBox comboFontSize;
  private JButton bSave;
  private JButton bCancel;
  Color color;
  
  public PreferencesDialog(JFrame parent, String title, String message)  {
    super(parent, title, true);
    // If there was a parent, set dialog position inside
    if(parent != null) {
      Dimension parentSize = parent.getSize(); // Parent size
      Point p = parent.getLocation();          // Parent position
        setLocation(p.x + parentSize.width/4,p.y + parentSize.height/4);
      }

      GridLayout gr = new GridLayout(4,2,1,1);
    
      JPanel panel = new JPanel();
      panel.setLayout(gr);      
      
      //initialize color combobox
      Vector vColour = new Vector(3);
      vColour.add("red");
      vColour.add("green");
      vColour.add("blue");
      JLabel lblColour = new JLabel("Select colour:");
      comboColour = new JComboBox(vColour);
      panel.add(lblColour);
      panel.add(comboColour);
      
      //initialize font combobox
      Vector vFont = new Vector(3);

      vFont.add("Serif"); //(generic name for TimesRoman)
      vFont.add("SansSerif"); //(generic name for Helvetica)
      vFont.add("Monospaced"); //(generic name for Courier)
      JLabel lblFont = new JLabel("Select logical font name:");
      comboFont = new JComboBox(vFont);
      panel.add(lblFont);
      panel.add(comboFont);
      
      //initialize font size combobox
      Vector vFontSize = new Vector(3);
      vFontSize.add("12");
      vFontSize.add("18");
      vFontSize.add("24");
      JLabel lblFontSize = new JLabel("Select font size:");
      comboFontSize = new JComboBox(vFontSize);
      panel.add(lblFontSize);
      panel.add(comboFontSize);
    
      //initialize Save button 
      bSave = new JButton("Save"); 
      bSave.addActionListener(this);
      panel.add(bSave);
      
      //initialize Cancel button 
      bCancel = new JButton("Cancel"); 
      bCancel.addActionListener(this);
      panel.add(bCancel);
      
      //create border 
      TitledBorder titleBorder = BorderFactory.createTitledBorder("Preferences");
      panel.setBorder(titleBorder);
      
      getContentPane().add(panel);
      
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      pack();                                    
      setVisible(true);
    }
 
  public void actionPerformed(ActionEvent evt)  {

    Object source = evt.getSource();
    
    if (source == bSave ){
      // The Button bOpenPreferences processing
      try{
        
        UserPreferences myPrefs = new UserPreferences();
        myPrefs.setPropFontLogicalName(comboFont.getSelectedItem().toString());
        myPrefs.setPropFontSize(Integer.parseInt(comboFontSize.getSelectedItem().toString()));
        
        try {
            Field field = Class.forName("java.awt.Color").getField(comboColour.getSelectedItem().toString());
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        myPrefs.setPropColour(color);
        
        //serialize UserPreferences
        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath("UserPreferences.ser");
        if(Files.notExists(path)) {
          System.out.println(path + " does not exist.");
        }
        
        try (FileOutputStream fOn = new  FileOutputStream("UserPreferences.ser");
            ObjectOutputStream oOn = new ObjectOutputStream(fOn); ) {
          
          oOn.writeObject(myPrefs); 
        } catch (IOException e) {
          e.printStackTrace();
        } 
         
        MyCustomizableGUI.upateFieldsData();
        setVisible(false);                        
        dispose();
               
       } catch (Exception e){
           e.printStackTrace();
       }
     } else if (source == bCancel ){
       try{
         setVisible(false);                        
         dispose();
                
        } catch (Exception e){
            e.printStackTrace();
         }
     }
  }
}
