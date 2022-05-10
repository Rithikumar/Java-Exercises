package com.learn.ch4.bitwise;

/**
 * <p>
 * Class in which different types of compound bitwise operators are practiced
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class OpBitEquals {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;

		a |= 4;
		b >>= 1;
		c <<= 1;
		a ^= c;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
