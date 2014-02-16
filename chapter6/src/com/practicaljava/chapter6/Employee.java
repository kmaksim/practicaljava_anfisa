package com.practicaljava.chapter6;

public class Employee extends Person implements Payable  {
	public Employee(String name) {
		super(name);

	}


	public Boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. "+ getName());
		 return true;
		
	}

}
