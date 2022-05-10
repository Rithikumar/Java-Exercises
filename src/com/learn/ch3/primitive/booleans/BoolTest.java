package com.learn.ch3.primitive.booleans;

/**
 * <p>
 * A test class used to learn how a boolean is used
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BoolTest {

	public static void main(String[] args) {
		boolean b;
		b = false;
		System.out.println("b is " + b);
		b = true;
		System.out.println("b is " + b);
		// if (boolean value) if the boolean value is true block inside if will be
		// executed
		if (b)
			System.out.println("This is executed");
		b = false;
		if (b)
			System.out.println("This is not executed.");
		// outcome of a relational operator is a boolean value
		System.out.println("10 > 9 is " + (10 > 9));
	}
}
