package com.pj.calculator.GridBagLayout;
import javax.swing.*;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
    // Declare all calculator's components.
	JPanel windowContent;
	private JTextField displayNumbers;
	private JTextField displayOperator;
	GridBagConstraints constraints;
	
	JButton[] Button;
	JPanel p1;
	private GridBagLayout layoutGBC;

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

    private void addComponent( Component component,
    		int row, int column, int width, int height )
	{
    	constraints.gridx = column; // set gridx                           
    	constraints.gridy = row; // set gridy                              
    	constraints.gridwidth = width; // set gridwidth                    
    	constraints.gridheight = height; // set gridheight                 
    	layoutGBC.setConstraints( component, constraints ); // set constraints
    	windowContent.add( component ); // add component                                 
	} // end method addComponent
    

  Calculator(){

	  windowContent= new JPanel();
	  String operators = "C=/*-+."; //".+-*/=C";
	  int numberOfNumButtons = 10;
	  int numOfButtons = numberOfNumButtons + operators.length();
	  Button = new JButton [numOfButtons];
	 
	 // Set the layout manager for this panel
      layoutGBC = new GridBagLayout() ;                                                       
	  constraints = new GridBagConstraints(); // instantiate constraints
	  windowContent.setLayout(layoutGBC);
	  
	  displayNumbers = new JTextField(30);
	  displayNumbers.setHorizontalAlignment(JTextField.RIGHT);
	  displayOperator = new JTextField(30);
	  
	// weightx and weighty for textArea1 are both 0: the default
	  // anchor for all components is CENTER: the default
	  constraints.fill = GridBagConstraints.BOTH;
	  addComponent( displayNumbers, 0, 0, 4, 1 );
	  addComponent( displayOperator, 1, 0, 4, 1 );

	  p1 = new JPanel();
	  GridLayout gl =new GridLayout(4,5); 
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

	  //add panel p1 to the second row, 0 column, 
	  //it will be 4 columns wide and it's height is 1 row
	  addComponent( p1, 2, 0, 4, 1 );
	  
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
