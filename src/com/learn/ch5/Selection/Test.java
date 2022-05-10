package com.learn.ch5.Selection;

/**
 * <p>
 * Exploring more about nested if's and else
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Test {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		int k = 102;
		int a = 4, b = 3, c = 2, d = 3;
		if (i == 10) {
			if (j < 20)
				a = b;// this is continuous if in which both are executed if true
			if (k > 100)
				c = d;
			else
				a = c;
			// else c = d;this throws error as statement contains more lines
		} else
			a = d;
		System.out.println("" + a + " " + b + " " + c + " " + d + " " + i + " " + j + " " + k);
	}
}
