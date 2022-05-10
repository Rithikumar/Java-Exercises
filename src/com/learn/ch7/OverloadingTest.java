package com.learn.ch7;

/**
 * <p>
 * Overloading methods with compatible datatype
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class OverloadingTest {

	public static int number(int name) {
		System.out.println("entered int");
		return 0;
	}

	public static int number(long name) {
		System.out.println("entered long");
		return 0;
	}

//	public static void number(int name) {
//		System.out.println("Error")
//	}

	public static void main(String[] args) {
		number(4);
		number(2);
	}
}
