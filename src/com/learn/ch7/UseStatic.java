package com.learn.ch7;

/**
 * <p>
 * Practicing static
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class UseStatic {
	static int a = 3;// first
	static int b;

	static void meth(int x) {
		System.out.println("x = " + x);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	// second
	static {
		System.out.println("Static block initialized.");
		b = a * 4;
	}

	// third
	public static void main(String[] args) {
		System.out.println("main started");
		meth(42);
	}
}
