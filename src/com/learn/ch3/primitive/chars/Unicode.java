package com.learn.ch3.primitive.chars;

/**
 * <p>
 * Class in which Unicode is explored more
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Unicode {
	/**
	 * Adding two chars
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char a = 65535;// limit of char
		System.out.println(a);//symbol not printed properly
		char ch1, ch2;
		ch1 = 88;
		ch2 = 'Y';

		System.out.print("ch1 and ch2: ");
		System.out.println(ch1 + " " + ch2);
	}
}
