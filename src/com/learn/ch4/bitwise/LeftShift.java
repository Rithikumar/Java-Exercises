package com.learn.ch4.bitwise;

/**
 * <p>
 * Exploring the working and uses of left shift
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class LeftShift {

	public static void main(String[] args) {
		byte a = 64, b; // 00100000 10000000
		int i;
		i = a << 2;
		b = (byte) (a << 2);
		System.out.println("Original value of a: " + a);
		System.out.println("i and b: " + i + " " + b);

		long a1 = 1; //
		a1 <<= 65;
		char a2 = '4';
		a2 <<= 2;
		char a3 = 'a';
		int g = a2 << 2 + a3 << 4;
		int a4 = 5;
		System.out.println(a4 << 2);
		System.out.println(g);
		System.out.println(a2);
		System.out.println(a1);

		byte a5 = (byte) 11101010;
		System.out.println(a5 <<= 3);
	}
}
