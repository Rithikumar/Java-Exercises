package com.learn.ch8;

/**
 * <p>Super class of simple example of inheritance </p>
 * @author rithi-zstch1028
 *
 */
class A {
	int i, j ;//The i and j are declared here
	private int y;//y is declared here
	
	void showij() {
		System.out.println("i and j: " + i + " " + j);
	}
}

/**
 * <p>Driver class of simple example of inheritance</p>
 * @author rithi-zstch1028
 *
 */
class B extends A{
	// Here B class extend A thus giving access to all its public member of superclass
	int k;
	
	void showk() {
		System.out.println("k: " + k);
	}
	
	void sum() {
		//int sum = i+j+k+y;//here y is not accessible because private access modifier
		System.out.println("i+j+k: " + (i+j+k));
		//here i and j are access from the superclass
	}
}
/**
 * <p>Driver class of simple example of inheritance</p>
 * @author rithi-zstch1028
 *
 */
public class SimpleInheritance {
	public static void main(String[] args) {
		A superOb = new A();
		B subOb = new B();
		
		//superclass may be used by itself
		superOb.j = 10;
		superOb.i = 20;
		System.out.println("Contents of superOb: ");
		superOb.showij();
		System.out.println();
		
		//The subclass has access to all public members of its subclass
		subOb.k = 9;
		//subOb.showij();
		subOb.i = 7;
		subOb.j = 8;
		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();
		System.out.println();
		
		System.out.println("Sum of i, j and k in subOb: ");
		subOb.sum();
	}
}
