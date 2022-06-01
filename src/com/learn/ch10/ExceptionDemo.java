package com.learn.ch10;

public class ExceptionDemo{
	static void compute(long a) throws NumberException{
		System.out.println("inside compute");
		if(a < 1000000000L || a > 9999999999L) {
			throw new NumberException(a);
		}
		System.out.println("Number is valid");
	}
	
	public static void main(String[] args) {
		try {
			compute(1);
			compute(20);
		}
		catch(NumberException e) {
			System.out.println(e);
		}
	}
}
