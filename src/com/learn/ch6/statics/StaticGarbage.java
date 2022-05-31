package com.learn.ch6.statics;

class A {
	static int num1 = 4;
	A(){
		System.out.println(num1);
	}
}

public class StaticGarbage {
	public static void main(String[] args) {
		System.out.println(A.num1);
		A a = new A();
	}
}
