package com.learn.ch3.primitive.integer;

/**
 * <p>
 * Ranges of all the datatype and what happens on overflow
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Range {

	public static void main(String[] args) {
		// byte = -128 to 127
		// short = –32,768 to 32,767
		// int = –2,147,483,648 to 2,147,483,647
		// long = –9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		byte a = 127;
		byte b = 2;
		byte c = (byte) (a + b);
		System.out.println((byte) a + 2);// give 129
		System.out.println(c);// gives 127
		// int[] ar = new int[2022337203];//java.lang.OutOfMemoryError
	}
}
