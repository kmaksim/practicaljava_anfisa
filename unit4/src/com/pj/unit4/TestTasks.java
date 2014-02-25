package com.pj.unit4;
import java.util.ArrayList;


public class TestTasks {

	/**
	 * todo: read tasks from file or generator
	 */
	public static ArrayList<String> tasks;
	
	public ArrayList<String> getTasks() {
		ArrayList<String> tasks = new ArrayList <String> ();
		tasks.add("Automation Tests");
		tasks.add("Manual Tests");
		tasks.add("Smoke Tests");
		tasks.add("Regression Tests");
		return tasks;
	}

}
