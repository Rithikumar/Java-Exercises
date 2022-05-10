package com.learn.ch7;

/**
 * <p>
 * Checking whether string is a pass by ref or pass by value
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class StringCheck {
	public static void main(String[] args) {
		String sample = "i am sample";
		method(sample);
		// sample = "i am not sample";
		System.out.println(sample);
		// because java is a pass by value
		// the value of the argument is set to parameter
		// As string is immutable when edited it assigns a new references to the
		// variable
		// so inside the method the change is shown but not outside
	}

	static void method(String sample) {

		sample = "i am not sample";
	}
}
