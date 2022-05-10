package com.learn.ch5.jump;

/**
 * <p>
 * More on breaking loops
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BreakNested {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.print("pass " + i + ": ");
			for (int j = 0; j < 100; j++) {
				if (j == 20)
					break;
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println("Loop Complete");

	}
}
