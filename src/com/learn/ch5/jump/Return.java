package com.learn.ch5.jump;

/**
 * <p>
 * Usage of return
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Return {
	public static void main(String[] args) {
		boolean t = true;
		System.out.println("Before the return.");
		if (t)
			return;
		System.out.println("This won't execute.");
	}
}
