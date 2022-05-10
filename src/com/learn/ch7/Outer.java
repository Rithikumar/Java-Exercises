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

	class Inner {

		void display() {
			System.out.println("Outer_x = " + outer_x);
		}
	}
}