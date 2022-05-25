package com.learn.ch9.interfaces;

public class Test implements CallBack {
	public static void callBack(int a) {
		System.out.println(a);
	}
	public static void main(String[] args) {
		CallBack.callBack(n);
		Test t = new Test();
		System.out.println(t.sum(4, 6));
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
}
