package com.learn.ch10;

public class ThrowDemo {
	static void demoProc() {
		try {
			throw new NullPointerException("demo");
		}
		catch(NullPointerException e) {
			System.out.println("Caught inside demoproc");
		}
	}
}
