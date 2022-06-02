package com.learn.ch7.overriding;

public class Parent1 {
	private int a = 14;
	int b = 13;
	
	void add() {
		System.out.println(a+b);
	}
	
	public void sub(int a , int b) {
		System.out.println(a-b);
	}
	
	public void sample() {
		System.out.println("sample");
	}
	
	public static void ex() {
		System.out.println("Parent example");
	}
}
