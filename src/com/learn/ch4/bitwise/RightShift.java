package com.learn.ch4.bitwise;

/**
 * <p>
 * Experimentation on right shift
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class RightShift {

	public static void main(String[] args) {
		int a = 0b10000000000000000000000000000000;
		System.out.println(a);
		System.out.println(a >> 3);
		// right shift used in loop
		for (int i = 0; i < 32; i++) {
			a = a >> 1;
			System.out.println(a);
		}
		System.out.println(a);// 11111111111111111111111111111111 = -1
		int b = 0b01111111111111111111111111111111;
		System.out.println(b);
		for (int i = 0; i < 32; i++) {
			b = b >> 1;
			System.out.println(b);
		}
		// modulo takes place in right shift too
		System.out.println(11 >> 33);
	}
}
