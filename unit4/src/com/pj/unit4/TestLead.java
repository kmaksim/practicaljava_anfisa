package com.pj.unit4;
import java.util.ArrayList;
public class TestLead {

	/**
	 * TestLead is initiated with tasks and testers
	 * arranges test process:
	 * finds appropriate tasks for testers (randomly. TODO: according to role)
	 * tells tester on which phone to perform which task
	 */
	public static ArrayList <String> testTasks;
	public static ArrayList<Tester> testers;
	
	public TestLead(TestTasks tasks, ArrayList<Tester> testers) {
		TestLead.testTasks = tasks.getTasks();
		TestLead.testers = testers;
	}
	
	public static String findAppropriateTaskForTester(Tester tester) {
		return testTasks.get((int) (Math.random()*testTasks.size()));
	}
	
	
	public static void organizeTestProcess( ArrayList<Phone> phones) {		
		//ArrayList <Phone> testPhones = phones;
		for (int i = 0;i< testers.size();i++) {
			String task = findAppropriateTaskForTester(testers.get(i));
			Util.log("TestLead: Assigning a task to perform " + task + " to "
					 +  testers.get(i).getName().toUpperCase() +" on phone: " 
					+ phones.get(i).getModel()
					);
			testers.get(i).test(phones.get(i), task);
		}	
	}
	
}
