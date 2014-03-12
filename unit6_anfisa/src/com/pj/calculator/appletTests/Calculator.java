package com.pj.calculator.appletTests;
import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.logging.Logger;

public class Calculator extends JApplet {
    /** Declare all calculator's components.*/
	static Logger log = Logger.getLogger("com.pj.calculator");
	private java.awt.Panel windowContent;
	private JTextField numbersLCD;
	private JTextField operatorLCD;
	GridBagConstraints constraints;
	
	JButton[] Button;
	JPanel p1;
	private GridBagLayout layoutGBC;

    public void setNumbersLCDValue(String val){
        numbersLCD.setText(val);
    }

    public String getNumbersLCDValue() {
        return numbersLCD.getText();
    } 
    
    public void setOperatorLCDValue(String val){
        operatorLCD.setText(val);
    }

    public String getOperatorLCDValue() {
        return operatorLCD.getText();
    } 

    private void addComponent( Component component,
    		int row, int column, int width, int height )
	{
    	constraints.gridx = column; // set gridx                           
    	constraints.gridy = row; // set gridy                              
    	constraints.gridwidth = width; // set gridwidth                    
    	constraints.gridheight = height; // set gridheight                 
    	layoutGBC.setConstraints( component, constraints ); 
    	windowContent.add( component );                                  
	} 
    
/** this paint method below does not work -- no background color*/
 public void paint(Graphics g) {
	 super.paint(g);
	 g.setColor(Color.blue); 
 }
    
  void initCalculator(){  

	  windowContent = new java.awt.Panel();
	  String operators = "C=/*-+."; 
	  int numberOfNumButtons = 10;
	  int totalNumOfButtons = numberOfNumButtons + operators.length();
	  Button = new JButton [totalNumOfButtons];
	 
	  /** Set the layout manager for this panel */
      layoutGBC = new GridBagLayout() ;                                                       
	  constraints = new GridBagConstraints(); // instantiate constraints
	  windowContent.setLayout(layoutGBC);
	  
	  numbersLCD = new JTextField(30);
	  numbersLCD.setEditable(false);
	  numbersLCD.setToolTipText("this box displays numbers");
	  numbersLCD.setHorizontalAlignment(JTextField.RIGHT);
	  operatorLCD = new JTextField(30);
	  operatorLCD.setEditable(false);
	  operatorLCD.setToolTipText("this box displays signs");
	  
	  /** weightx and weighty for textArea1 are both 0: the default, anchor for all components is CENTER: the default */
	  constraints.fill = GridBagConstraints.BOTH;
	  addComponent( numbersLCD, 0, 0, 4, 1 );
	  addComponent( operatorLCD, 1, 0, 4, 1 );

	  p1 = new JPanel();
	  GridLayout gl =new GridLayout(4,5); 
	  p1.setLayout(gl);
	  
	  CalculatorEngine calcEngine = new CalculatorEngine(this);

	  for (int i=0;i<totalNumOfButtons;i++) {
		if ( i < numberOfNumButtons) {
			  Button[i] = new JButton ("" + i);
		  } else {
			  char o = operators.charAt(totalNumOfButtons-1-i);
			  Button[i] = new JButton("" + o); 
		  }
		  
		  p1.add(Button[i]);
		  Button[i].addActionListener(calcEngine); 
	  }

	  /**add panel p1 to the second row, 0 column, it will be 4 columns wide and it's height is 1 row */
	  addComponent( p1, 2, 0, 4, 1 );
	  add(windowContent);
	  
    }

    public void init() {
    	new Calculator();
    	initCalculator();
    }	

}
