package com.pj.unit4;

public class Tester {

	/**
	 * Tester perform switches the phone on, making screenshots and performs tests
	 */

	String name;
	String role;
	public Tester(String name, String role) {
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	//polimorfism example:
	public void test(Phone p1, String task) {
		Util.log("Tester: " + p1.switchPhoneOn());
		Util.log("Tester: device OS is" + p1.getOSVersion());
		Util.log("Tester: " + p1.makeScreenshot());
		Util.log("Tester: " + "Test results: " +  p1.runTest(task));
		
	}

}
