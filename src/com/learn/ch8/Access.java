package com.learn.ch8;

/*
 * In a class hierarchy, private members remain private to their class
 */

/**
 * <p>
 * This is superclass of the program
 * </p>
 * 
 * @author rithi-zstch1028
 */
class C {
	protected int i;// protected
	private int j;//private to A
	void setij(int x , int y) {
		i = x;
		j = y;
	}
	
	void sum() {
		System.out.println(i+j);
		
	}
	
	static void add(int a , int b) {
		System.out.println(a+b);
	}
	
//	@Override
//	public String toString() {
//		return null;
//	}
	
	
}

class D extends C {
	int total;
	
	@Override
	void sum() {
		total = i;
		//total = i + j; //Error, j is not accessible here
	}
	
	public static void add(int a , int b) {
		
	}

}

public class Access {
	public static void main(String[] args) {
		D subOb = new D();
		subOb.setij(10, 12);
		subOb.sum();
		System.out.println("The Total is " + subOb.total);
	}
}
