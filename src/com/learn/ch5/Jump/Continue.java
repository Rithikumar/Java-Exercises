package com.learn.ch5.Jump;

/**
 * <p>
 * Basic program in which continue is practiced
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */

public class Continue {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			if (i % 2 == 0)
				continue;
			System.out.println();
		}
	}
}
