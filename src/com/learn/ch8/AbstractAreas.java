package com.learn.ch8;

abstract class Figures {
	double dim1;
	double dim2;
	
	Figures(double a , double b) {
		dim1 = a;
		dim2 = b;
	}
	
	abstract double area();
}

class Rectangles extends Figures {
	Rectangles(double a , double b) {
		super(a,b);
	}
	
	double area() {
		System.out.println("Inside Area for Rectangle.");
		return dim1 * dim2;
	}
}

class Triangles extends Figures {
	Triangles (double a , double b) {
		super(a,b);
	}
	
	double area() {
		System.out.println("Inside Area for Triangle");
		return dim1 * dim2 / 2;
	}
}

public class AbstractAreas {
	public static void main(String[] args) {
		// Figure f = new Figure(10,10); // illegal now
		Rectangles r = new Rectangles(9,5);
		Triangles t = new Triangles(10,8);
		Figures figuref;
		figuref = r;
		System.out.println("Area is " + figuref.area());
		figuref = t;
		System.out.println("Area is " + figuref.area());
	}
}
