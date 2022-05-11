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
	int i;//default
	private int j;//private to A
	
	void setij(int x , int y) {
		i = x;
		j = y;
	}
}

class D extends C {
	int total;
	void sum() {
		total = i;
		//total = i + j; //Error, j is not accessible here
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
