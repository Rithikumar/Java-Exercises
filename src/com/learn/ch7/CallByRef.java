package com.learn.ch7;

/**
 * <p>
 * Example of call by reference
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Test5 {
	int a, b;

	Test5(int i, int j) {
		a = i;
		b = j;
	}

	// pass an object;
	void meth(Test5 o) {
		o.a *= 2;
		o.b /= 2;
	}
}

/**
 * <p>
 * Driver class
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class CallByRef {

	public static void main(String[] args) {
		Test5 ob = new Test5(15, 20);

		System.out.println("Values: " + ob.a + " and " + ob.b);

		ob.meth(ob);

		System.out.println("Values: " + ob.a + " and " + ob.b);
	}
}
