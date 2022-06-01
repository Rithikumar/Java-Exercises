package com.learn.ch6.statics;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000L);
		System.out.println(StaticBlock.num);
	}
}
