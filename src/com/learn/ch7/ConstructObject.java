package com.learn.ch7;

/**
 * <p>
 * Used to check the object passing
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Test2 {
	double width;
	double height;
	double depth;

	Test2(Test2 op) {
		width = op.width;
		height = op.height;
		depth = op.depth;
	}

	Test2(double w, double h, double d) {
		width = w;
		height = h;
		depth = d;
	}

	Test2() {
		width = -1;
		height = -1;
		depth = -1;
	}

	Test2(double len) {
		width = height = depth = len;
	}

	double volume() {
		return width * height * depth;
	}

}

/**
 * <p>
 * Test class
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ConstructObject {

	public static void main(String[] args) {

		Test2 t1 = new Test2(10, 20, 30);
		Test2 t2 = new Test2();
		Test2 t3 = new Test2(7);

		Test2 clone = new Test2(t1);

		System.out.println(t1.volume());
		System.out.println(t2.volume());
		System.out.println(t3.volume());
		System.out.println(clone.volume());

	}

}
