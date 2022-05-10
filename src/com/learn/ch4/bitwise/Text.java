package com.learn.ch4.bitwise;

/**
 * <p>
 * More on Right shift and its experimentation
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Text {

	public static void main(String[] args) {

		// bitwise not
		int a = ~4;// 00000000 00000000 00000000 00000100 binary for 4
		// not 4 11111111 11111111 11111111 11111011
		// value -5
		byte a1 = 5;
		int b = a & a1;// 11111011 even though two different types are used no error is thrown
		// & 00000101
		// 00000001 thus 1
		int c1 = '4';
		int c = '4' | 4;// 00110100
		// 00000100
		// 00110100 thus 52
		// double a2 = ~5.3; bitwise operator can be used for floating numbers
		int l1 = 36; // no change even though big datatype is used
		int y1 = l1 & 4;// 4
		System.out.println(y1);
		long l = 36;
		long y = l & 4;

		char c12 = '2' & 'b'; // 4
		System.out.println(c12);
		System.out.println(y);
		System.out.println(~l);
		System.out.println(a);
		System.out.println(c);
		System.out.println(b);
		System.out.println(a);
	}
}
