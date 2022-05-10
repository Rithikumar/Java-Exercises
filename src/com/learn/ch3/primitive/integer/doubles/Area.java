package com.learn.ch3.primitive.integer.doubles;

/**
 * <p>
 * The class in which area is found using datatype double
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Area {
	public static void main(String[] args) {
		double pi, r, a;

		r = 10.8;// radius
		pi = 3.1416;
		a = pi * r * r;// area = pi * r^2

		System.out.println("Area is " + a);

	}
}
