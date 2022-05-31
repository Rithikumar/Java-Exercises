package com.learn.ch10;

public class FinallyDemo {
	// Through an exception out of the method
	static void procA() {
		try {
			System.out.println("inside procA");
			throw new RuntimeException("demo");
		}
		catch (Exception e) {
			System.out.println("Exception caught");
		}
		finally {
			System.out.println("procA's finally");
		}
	}

	// Return from within a try block
	static int procB() {
		try{
			System.out.println("inside procB");
			return 14;
		}
		finally {
			System.out.println("procB's finally");
		}
	}
	
	//Execute a try block normally.
	static void procC() {
		try {
			System.out.println("inside procC");
		}
		finally {
			System.out.println("procC's finally");
		}
	}
	
	public static void main(String[] args) {
		procA();
		System.out.println(procB());
		procC();
	}
}
