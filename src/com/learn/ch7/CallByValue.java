package com.learn.ch7;

/**
 * <p>
 * Call By Value Example
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Test4 {
	/**
	 * Here the parameters are altered within method
	 * 
	 * @param i is multiplied by 2
	 * @param j is divided by 2
	 */
	void meth(int i, int j) {
		i *= 2;
		j /= 2;
	}
}

/**
 * <p>
 * Test class to check the call by value methods
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class CallByValue {
	public static void main(String[] args) {
		Test4 ob = new Test4();

		int a = 15;
		int b = 20;

		System.out.println("Values: " + a + " and " + b);

		ob.meth(a, b);// a and b are passed into method meth in which the values are altered
		// but it did not affect the original value
		System.out.println("Values: " + a + " and " + b);
	}

}
