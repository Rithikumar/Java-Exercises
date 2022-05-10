package com.learn.ch7;

/**
 * <p>
 * More on varArgs part 3
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class VarArgs3 {

	static void vaTest(int v) {
		System.out.print("vaTest(int): " + "Number of args: " + 1 + "Contents: ");
		System.out.println(v + " ");
		System.out.println();
	}

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

	static void vaTest(String msg, int... v) {
		System.out.print("vaTest(String, int...): " + msg + v.length + " Content: ");
		for (int x : v)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		vaTest(1);
		vaTest(1, 2, 3);
		vaTest("Testing: ", 10, 20);
		vaTest(true, false, true);
	}
}
