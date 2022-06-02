package com.learn.ch7;

/**
 * <p>
 * More on varArgs
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class VarArgs2 {

	static void vaTest(String msg, int... v) {
		System.out.print(msg + v.length + " Content: ");
		
		for (int x : v)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		vaTest("One varargs: ", 10);
		vaTest("Three varargs: ", 1, 2, 3);
		vaTest("No varargs: ");
	}

}
