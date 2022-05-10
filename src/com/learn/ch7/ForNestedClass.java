package com.learn.ch7;

public class ForNestedClass {
	public static void main(String[] main) {
		Outers outer = new Outers();
		outer.test();
	}
}

//Define an inner class within a for loop.
class Outers {
	int outer_x = 100;

	void test() {
		for (int i = 0; i < 10; i++) {
			class Inner {
				void display() {
					System.out.println("display: outer_x = " + outer_x);
				}
			}
			Inner inner = new Inner();
			inner.display();
		}
	}
}
