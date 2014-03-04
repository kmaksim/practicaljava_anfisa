package com.pj.calculator.GridLayout;
import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
    // Declare all calculator's components.
	JPanel windowContent;
	private JTextField displayNumbers;
	private JTextField displayOperator;
	
	JButton[] Button;
	//JComponent[] Button;
	JPanel p1;

    public void setNumbersLCDValue(String val){
        displayNumbers.setText(val);
    }

    public String getNumbersLCDValue() {
        return displayNumbers.getText();
    } 
    
    public void setDisplayOperatorValue(String val){
        displayOperator.setText(val);
    }

    public String getDisplayOperatorValue() {
        return displayOperator.getText();
    } 

      // Constructor  creates the components
      // and adds the to the frame using combination of 
      // Borderlayout and Gridlayout

  Calculator(){

	  windowContent= new JPanel();
	  String operators = ".+-*/=C";
	  int numberOfNumButtons = 10;
	  int numOfButtons = numberOfNumButtons + operators.length();
	  Button = new JButton [numOfButtons];

	 // Set the layout manager for this panel
	  BorderLayout bl = new BorderLayout(); 
	  GridBagConstraints constraints = new GridBagConstraints();
      windowContent.setLayout(bl);
      //add text fields for number and sign output
	  displayNumbers = new JTextField(30);
	  displayNumbers.setHorizontalAlignment(JTextField.RIGHT);
	  displayOperator = new JTextField(30);
	  windowContent.add("North",displayNumbers);
	  windowContent.add("South",displayOperator);

	  p1 = new JPanel();
	  
	  GridLayout gl =new GridLayout(4,3); 
	  p1.setLayout(gl);
	  CalculatorEngine calcEngine = new CalculatorEngine(this);

	  for (int i=0;i<numOfButtons;i++) {
		if ( i < numberOfNumButtons) {
			  Button[i] = new JButton ("" + i);
		  } else {
			  char o = operators.charAt(numOfButtons-1-i);
			  Button[i] = new JButton("" + o); 
		  }
		  
		  p1.add(Button[i]);
		  Button[i].addActionListener(calcEngine); 
	  }

				          
      windowContent.add("Center",p1);

	  //Create the frame and set its content pane	               
      JFrame frame = new JFrame("Calculator");
      frame.setContentPane(windowContent);
      
      frame.pack(); // Set the size of the window to be big enough to accommodate all controls 
      frame.setResizable(false);
	  // Display the window
	  frame.setVisible(true);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


     public static void main(String[] args) {

	  new Calculator();
     
     }
}
