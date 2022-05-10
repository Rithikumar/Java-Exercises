package com.learn.ch3.primitive.conversion;

/**
 * <p>
 * Class in which type casting between from int to char and vice versa is
 * experimented
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class IntToChar {
	public static void main(String[] args) {
		char a = 'a';
		char b = '1';
		char c = '-';
		System.out.println(a + " " + b + " " + c);
		int d = a;//automatic type conversion 
		int e = b;
		int f = c;
		System.out.println(d + " " + e + " " + f);
		int g = 1;
		// (error)char h = g
		char h = (char) g;
		int i = 2;
		int j = 3;
		int k = 4;
		System.out.println((char) i + " " + (char) j + " " + (char) k);
		char l = '9';
		char m = '1';
		char n = (char) (l + m);
		System.out.println(l + m);
		System.out.println(l);
		System.out.println(l + "" + m);
		System.out.println(n);
	}
}
