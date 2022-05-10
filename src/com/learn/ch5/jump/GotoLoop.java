package com.learn.ch5.jump;

/**
 * <p>
 * More on labeled breaks
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class GotoLoop {
	public static void main(String[] args) {
		outer: for (int i = 0; i < 3; i++) {
			System.out.print("Pass " + i + ": ");
			for (int j = 0; j < 100; j++) {
				if (j == 10)
					break outer;
				System.out.print(j + " ");
			}
			System.out.println("this will not print");
		}
	}
}
