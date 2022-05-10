package com.learn.ch7;

/**
 * <p>Passing object as a argument</p>
 * @author rithi-zstch1028
 *
 */
class Test1 {
	int a;
	int b;
	
	Test1(int i , int j) {
		a = i;
		b = j;
	}
	
	// return true if o is equal to the invoking object
	boolean equals(Test1 t) {
		if(t.a == a && t.b == b ) return true;
		return false;
	}
}

public class PassObject {
	
	public static void main(String[] args) {
		Test1 o = new Test1(100,22);
		Test1 o1 = new Test1(100,22);
		Test1 o2 = new Test1(-1,-1);
		
		System.out.println(o.equals(o1));
		System.out.println(o.equals(o2));
	}
}
