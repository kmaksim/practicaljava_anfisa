package com.pj.unit4;

public class Lumia1020 implements Nokia {
	/**
	 * 
	 */
	public String os = "Windows";
	public String model = "Lumia1020";
	public String color;
	public String ip;


	public Lumia1020(String color, String ip) {
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
		return("To switch on " + this.model + " press the button on the side of the phone");
	}
	
	public String makeScreenshot() {
		return("To make a screenshot hold powerbutton and windows icon");
	}
	
	public boolean runTest() {
		Util.log("No tests yet implemented for this OS");
		return false;
		
	}

	public boolean runTest(String task) {
		Util.log("I'm performing: " + task);
		return false;
	}

}
