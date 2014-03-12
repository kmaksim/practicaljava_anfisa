package com.pj.calculator.GridBagLayout1;

import java.awt.event.ActionListener; 
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class CalculatorEngine implements ActionListener {
 
 Calculator parent; // a reference to the Calculator
 public static String numbersLCDValue; // LCD output, all data is taken from there
 private String num1; // first number to perform operation on
 private String num2; // second number to perform operation on
 private String savedOperator; //operator, saved from previous step
 private Boolean clearLCDFlag; // to switch on/off after operators/digits/dot input
 private String savedPressedButtonValue; // state of last pressed button
 	
 // Constructor stores the reference to the 
 // Calculator window in  the member variable parent
 CalculatorEngine(Calculator parent){
   this.parent = parent;
   initDisplayValuesAndFlags(); 
 }
 
 public String performCalculation(String num1, String num2,String operator) {
	 ScriptEngineManager mgr = new ScriptEngineManager();
	 ScriptEngine engine = mgr.getEngineByName("JavaScript");
	 String res;
	 Calculator.log.info("num1 " + num1 
			 + " operator "+ operator +  " num2 " +  num2);
	 try {
		 res = engine.eval(num1 + operator + num2).toString();
		 return res;
	} catch (ScriptException e) {
		e.printStackTrace();
	}
	return "failed to calculate"; //return this if was unable to calculate
 }

 public void actionPerformed(ActionEvent e){
   //make calculations depending on pressed button
   JButton clickedButton =  (JButton) e.getSource();
   String clickedButtonLabel = clickedButton.getText();
   numbersLCDValue=parent.getNumbersLCDValue();
   Calculator.log.info("pressed " + clickedButtonLabel 
		   +  " num1<" + num1 
		   + "> num2<" + num2  
		   + "> toDisplay<" + numbersLCDValue 
		   + ">" );
   switch (clickedButtonLabel) {
   	   case "=":
   		   // ignore if previous operator was =
   		   // clear . near 0. 
   		   // set clearLCDFlag if there is number in LCD
   		   // if there are num1 and num 2 then perform operation
   		Calculator.log.info("savedOperator>" +savedOperator + "<");
   		   if (!savedOperator.equals("=")) {
			   if (!numbersLCDValue.isEmpty() && num1.isEmpty()) {
				   num1 = "";
				   clearLCDFlag = true;
				   if (numbersLCDValue.equals("0.")) {
					   parent.setNumbersLCDValue("0");
					   numbersLCDValue=parent.getNumbersLCDValue(); 
				   }
				   break;
			   }
			   Calculator.log.info("parent.getDisplayOperatorValue>" +parent.getDisplayOperatorValue() + "<");
			   if (!numbersLCDValue.isEmpty() && !num1.isEmpty() 
					   && !savedOperator.equals(clickedButtonLabel)
					   && !(parent.getDisplayOperatorValue().length()>0)) {
				   num2 = numbersLCDValue;
				   num1 = performCalculation(num1,num2,savedOperator);
				   if (num1.equals("Infinity")) {
						 JOptionPane.showMessageDialog(null, "Sorry, I can't calculate " +
						 		"-- division by zero");
						 parent.setNumbersLCDValue("0");
					 } else {
						 parent.setNumbersLCDValue(num1);
					 }
				   clearLCDFlag = true;
				   num2="";
				   num1="";
			   }
			   parent.setDisplayOperatorValue("");
   		   }
   		   savedOperator = "=";
   		   num1="";
		   break;
	   case "*": case "/": case "-": case "+":
		   // perform operation if num1 and num2 are entered
		   // ignore if previous operator was one of *+/+
		   // add number from LCD to num 1
		   parent.setDisplayOperatorValue(clickedButtonLabel);
		   if (!savedPressedButtonValue.matches("[*+-/]")) {
			   if (!numbersLCDValue.isEmpty() && num1.isEmpty()) {
				   num1 = numbersLCDValue;
				   clearLCDFlag = true;
				   savedOperator = clickedButtonLabel;
				   break;
			   } 
			   if (!numbersLCDValue.isEmpty() && !num1.isEmpty() 
					   ) {
				   num2 = numbersLCDValue;
				   num1 = performCalculation(num1,num2,savedOperator);
				   if (num1.equals("Infinity")) {
						 JOptionPane.showMessageDialog(null, "Sorry, I can't calculate " +
						 		"-- division by zero");
						 parent.setNumbersLCDValue("0");
					 } else {
						 parent.setNumbersLCDValue(num1);
					 }
				   numbersLCDValue=parent.getNumbersLCDValue();
				   clearLCDFlag = true;
			   }
		   }
		   parent.setDisplayOperatorValue(clickedButtonLabel);
		   savedOperator = clickedButtonLabel; //keep operator value till the next calculation
		   break;
	   case ".":
		   // check if it was pressed multiple times and if there is alreday a dot
		   // ignore it then
		   // if LCD was clear enter 0.
		   if (clearLCDFlag) {
			   numbersLCDValue = "0.";
			   parent.setNumbersLCDValue("0.");
			   clearLCDFlag = false;
			   break;
		   } 
		   if (numbersLCDValue.equals("")) {
			   numbersLCDValue = "0.";
			   parent.setNumbersLCDValue(numbersLCDValue);
			   break;
		   }  
		   if (numbersLCDValue.indexOf(".") == -1) { 
			   numbersLCDValue = parent.getNumbersLCDValue() + ".";
			   parent.setNumbersLCDValue(numbersLCDValue);
			   break;
		   }
		   System.out.println("wrong path");
		   break;   
	   case "C":
		   initDisplayValuesAndFlags();
		   break;
	   case "0": case "1": case "2": case "3": case "4":
	   case "5": case "6": case "7": case "8": case "9":
		   parent.setDisplayOperatorValue("");
		   if (clearLCDFlag) {
			   parent.setNumbersLCDValue("");
			   clearLCDFlag = false; 
		   }
		   numbersLCDValue = parent.getNumbersLCDValue() + clickedButtonLabel;
		   parent.setNumbersLCDValue(numbersLCDValue);
		   break;   
   }
   savedPressedButtonValue=clickedButtonLabel;
 }

	private void initDisplayValuesAndFlags() {
		parent.setNumbersLCDValue("");
		parent.setDisplayOperatorValue("");
		numbersLCDValue="";
		num1="";
		num2="";
		clearLCDFlag=false;
		savedOperator = "";
		savedPressedButtonValue="";
	}
}
