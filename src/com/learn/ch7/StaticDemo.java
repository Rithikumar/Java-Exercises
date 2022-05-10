package com.learn.ch7;

/**
 * <p>
 * Demo on static
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class StaticDemo {
	public static void main(String[] args) {
		StaticByName.callme();
		StaticByName.b = 4;
		System.out.println("b = " + StaticByName.b);
	}
}

class StaticByName {
	static int a = 42;
	static int b = 99;

	static void callme() {
		System.out.println("a = " + a);
	}
}