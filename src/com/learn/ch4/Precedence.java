package com.learn.ch4;

/**
 * <p>
 * More on working of Precedence
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Precedence {

	public static void main(String[] args) {
		System.out.println((2 >> 1) + 3);// brackets take the highest precedence
		System.out.println(4 | 4 + 2 >> 1 & 7);// even though works
		System.out.println((4 | (((4 + 2) >> 1) & 7)));// right way to present
	}
}
