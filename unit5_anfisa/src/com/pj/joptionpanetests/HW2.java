package com.pj.joptionpanetests;
import javax.swing.JOptionPane;

public class HW2
{
   public static void main(String[] args)
   {
      String name = JOptionPane.showInputDialog("What is your name?");
      System.out.println(name);
      String task = JOptionPane.showInputDialog("My name is " + name + "! What would you like me to do");
      JOptionPane.showMessageDialog(null, "I'm sorry, I can't do that -- " + task );
   }
}