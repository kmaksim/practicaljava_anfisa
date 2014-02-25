package com.pj.unit4;

public class SamsungNote3 implements Samsung {
	/**
	 * 
	 */
	public String os = "Android 4.4";
	public String model = "Samsung Galaxy Note 3";
	public String color;
	public String ip;


	public SamsungNote3(String color, String ip) {
		this.color =  color;
		this.ip = ip;

	}
	
	
	public String getOSVersion() {
		return this.os;
	}
	
	public String getColor () {
		return this.color;
	}
	
	public String getModel () {
		return this.model;
	}
	
	public String switchPhoneOn() {
		return("To switch on "  + this.model + 
				" press the button on the right side of the phone");
	}
	
	public String makeScreenshot() {
		return("To make a screenshot hold powerbutton and windows icon");
	}
	
	public boolean runTest() {
		Util.log("No tests yet implemented for this OS");
		return false;
	}

	public boolean runTest(String task) {
		Util.log("I'm performing " + task);
		return true;
	}

	public boolean isPenPresent() {
		return true;
		
	}

}
