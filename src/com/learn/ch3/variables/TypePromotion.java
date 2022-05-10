package com.learn.ch3.variables;

/**
 * <p>
 * Class in which type promotion is learnt and experimented
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class TypePromotion {
	public static void main(String[] args) {
		byte b = 42;
		char c = 'a';
		short s = 1024;
		int i = 50000;
		float f = 5.67f;
		double d = .1234;
		double result = (f * b) + (i / c) - (d * s);// The type promoted from their datatype to int or double
		System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
		// This is form in which they type promoted
		// f *b is promoted to double
		// i/c is promoted to int
		// d * s is promoted to double
		System.out.println(result);
	}
}
