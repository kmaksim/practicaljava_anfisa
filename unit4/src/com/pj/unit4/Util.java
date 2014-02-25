package com.pj.unit4;

public class Util {
	/**
	 * Util is a set of supplemental methods
	 */

	public static void log(String str) {
		System.out.println(str);
		//Thread.currentThread().getStackTrace()[1]  -- calling class
	}
	
	public static void log(int i) {
		System.out.println(i);
	}
}
