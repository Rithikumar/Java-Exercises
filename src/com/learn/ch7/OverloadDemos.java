package com.learn.ch7;

/**
 * <p>
 * Automatic type conversions apply to overloading
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Test {

	/**
	 * prints that no parameter is found
	 */
	void test() {
		System.out.println("No paramters");
	}

	/**
	 * prints the value of parameters a and b
	 * 
	 * @param a
	 * @param b
	 */
	void test(int a, int b) {
		System.out.println("a and b: " + a + " " + b);
	}

	/**
	 * prints the value of the parameter
	 * 
	 * @param a
	 */
	void test(double a) {
		System.out.println("Inside test(double) a: " + a);
	}
	
}

public class OverloadDemos {
	public static void main(String[] args) {
		Test ob = new Test();
		int i = 88;
		ob.test();
		ob.test(10,20);
		
		ob.test(i);
		ob.test(123.25);
		
	}
}






