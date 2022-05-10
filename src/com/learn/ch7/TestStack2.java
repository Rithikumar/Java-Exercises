package com.learn.ch7;

/**
 * <p>
 * Driver class used to run supervised stack
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class TestStack2 {
	public static void main(String[] args) {
		SupervisedStack stc = new SupervisedStack(5);
		SupervisedStack stc1 = new SupervisedStack(8);

		for (int i = 0; i < 5; i++)
			stc.push(i);
		for (int i = 0; i < 8; i++)
			stc1.push(i);

		for (int i = 0; i < 5; i++)
			System.out.print(stc.pop() + " ");
		System.out.println();
		for (int i = 0; i < 8; i++)
			System.out.print(stc1.pop() + " ");
	}
}
