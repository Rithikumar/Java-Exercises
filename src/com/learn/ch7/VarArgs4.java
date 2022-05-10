package com.learn.ch7;

/**
 * <p>
 * Last part on varArgs
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class VarArgs4 {
	static void vaTest(int... v) {
		System.out.print("vaTest(int ...): " + "Number of args: " + v.length + "Contents: ");
		for (int x : v)
			System.out.println(x + " ");
		System.out.println();
	}

	static void vaTest(boolean... v) {
		System.out.print("vaTest(boolean ...): " + "Number of args: " + v.length + "Contents: ");
		for (boolean x : v)
			System.out.println(x + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		vaTest(1, 2, 3);// ok
		vaTest(true, false, true);// ok
		// vaTest(); //Error
	}
}
