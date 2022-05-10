package com.learn.ch7;

/**
 * <p>
 * Demonstrate method overloading
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class OverloadDemo {

	/**
	 * Prints that no parameter is given
	 */
	void test() {
		System.out.println("No parameters");
	}

	/**
	 * Prints the value of parameter
	 * 
	 * @param a , value to be printed
	 */
	void test(int a) {
		System.out.println("a: " + a);
	}

	/**
	 * Prints the value of the parameters a and b
	 * 
	 * @param a , first value
	 * @param b , second value
	 */
	void test(int a, int b) {
		System.out.println("a and b: " + a + " " + b);
	}

	/**
	 * Returns the square of the value
	 * 
	 * @param a
	 * @return
	 */
	double test(double a) {
		System.out.println("a: " + a);
		return a * a;
	}
}

public class Overload {
	public static void main(String[] args) {
		OverloadDemo ob = new OverloadDemo();
		double result;

		ob.test();
		ob.test(10);
		ob.test(10, 20);
		result = ob.test(123.25);

		System.out.println("Result of ob.test(123.25): " + result);
	}
}
