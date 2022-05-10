package com.learn.ch3.Variables;

/**
 * <p>
 * More on Type Conversion
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class TypeConversion {
	public static void main(String[] args) {
		byte b;
		int i = 257;
		double d = 323.142;

		System.out.println("\nConversion of int to byte.");
		b = (byte) i;// as the number exceeds the range of byte, it conitnues within the range
		// that is if 129 is type casted into byte , it goes like
		// 127 , -128 , -127 thus prints -127
		// the same happens for all type casting
		System.out.println("i and b " + i + " " + b);

		System.out.println("\nConversion of double to int.");
		i = (int) d;
		System.out.println("i and d " + i + " " + d);

		System.out.println("\nConversion of double to byte.");
		b = (byte) d;
		System.out.println("d and b " + d + " " + b);

		System.out.println(40 * 50 / 100);
		byte g = 89;

	}
}
