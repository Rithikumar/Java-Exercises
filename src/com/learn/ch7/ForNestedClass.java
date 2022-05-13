package com.learn.ch7;

/**
 * <p>
 * The driver class for the class outer
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ForNestedClass {
	public static void main(String[] main) {
		Outers outer = new Outers();
		outer.test();
	}
}

/**
 * <p>
 * A class in which i studied abniut
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Outers {
	int outer_x = 100;

	void test() {
		for (int i = 0; i < 10; i++) {
			/**
			 * <p>Nested class</p>
			 * @author rithi-zstch1028
			 *
			 */
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
