package com.learn.ch10;

public class NumberException extends Exception{
	private long detail;
	
	NumberException(long a){
		detail = a;
	}
	
	public String toString() {
		return "Exception: Given number "+detail+" is not a applicable phone number";
	}
}