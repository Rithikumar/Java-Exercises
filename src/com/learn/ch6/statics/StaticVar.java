package com.learn.ch6.statics;

class Ex1{
	public static int num = 14;
}

public class StaticVar {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Ex1.num);
		Thread.sleep(10000);
		System.gc();
		System.out.println(Ex1.num);
	}
}
