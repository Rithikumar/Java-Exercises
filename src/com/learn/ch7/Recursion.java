package com.learn.ch7;

/**
 * <p>Simple program to understand recursion</p>
 * @author rithi-zstch1028
 *
 */
public class Recursion {
	
	public static int fact(int a) {
		if(a == 0)
			return 1;
		return a*(fact(a-1));
	}
	
	public static void main(String[] args) {
		System.out.println(fact(3));
		System.out.println(fact(4));
		System.out.println(fact(5));
	}

}
