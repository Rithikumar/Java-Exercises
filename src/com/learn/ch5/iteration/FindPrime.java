package com.learn.ch5.iteration;

/**
 * <p>
 * A simple program to find whether the given number is prime or not using a for
 * loop
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class FindPrime {
	public static void main(String[] args) {
		// int num;
//		boolean isPrime = true;
//
//		num = 7;
//		for (int i = 2; i <= num / i; i++) {
//			if ((num % i) == 0) {
//				isPrime = false;
//				break;
//			}
//		}
//		if (isPrime)
//			System.out.println("Prime");
//		else
//			System.out.println("Not Prime");

		for (int i = 1; i <= 5; i++) {

			System.out.print(i + (i == 5 ? "" : ","));

		}
	}
}
