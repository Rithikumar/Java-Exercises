package com.learn.ch7;

/**
 * <p>
 * Checking nested classes
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Outer {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.test();
	}
}
class Demo{
	int outer_x = 100;

	void test() {
		Inner innner = new Inner();
		innner.display();
	}
	//Inner class starts here
	class Inner {
		//can access the variables present in the outer loop
		void display() {
			System.out.println("Outer_x = " + outer_x);
		}
	}
	
	
}



