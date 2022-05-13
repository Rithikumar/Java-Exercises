package com.learn.ch7;

/**
 * <p>
 * This program demonstrates the difference between public and private
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Test7 {
	int a;// default access
	public int b;// public access
	private int c;// private access

	// methods to access c;
	void setc(int i) {
		c = i;
	}

	int getc() {
		return c;
	}
}

class AccessTest {
	public static void main(String[] args) {
		Test7 ob = new Test7();

		ob.a = 10;
		ob.b = 20;
		// ob.c = 100 Error
		ob.setc(100);
		System.out.println(ob.getc());
	}
}
