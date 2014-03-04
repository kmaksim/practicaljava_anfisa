//Calculator With FlowLayout
package com.pj.lesson9.examples;
import javax.swing.*;
import java.awt.FlowLayout;
 
public class SimpleCalculator{
 public static void main(String[] args) {
  // 1. Create a panel
    JPanel windowContent= new JPanel();
 
  // 2. Set a layout manager for this panel
    FlowLayout fl = new FlowLayout(); 
    windowContent.setLayout(fl);

  // 3. Create controls in memory 
    JLabel label1 = new JLabel("Number 1:");
    JTextField field1 = new JTextField(10);
    JLabel label2 = new JLabel("Number 2:");
    JTextField field2 = new JTextField(10);
    JLabel label3 = new JLabel("Sum:");
    JTextField result = new JTextField(10);
    JButton buttonAdd = new JButton("Add");
 
  // 4. Add controls to the panel
    windowContent.add(label1); 
    windowContent.add(field1);
    windowContent.add(label2);
    windowContent.add(field2);
    windowContent.add(label3);
    windowContent.add(result);
    windowContent.add(buttonAdd);
  
    JFrame frame = new JFrame("Simple summator");
    frame.setContentPane(windowContent);
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(2);
    frame.setVisible(true);
    
   }
 }
 