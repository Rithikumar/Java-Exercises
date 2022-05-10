package com.learn.ch6;

/**
 * <p>
 * Using this class as storage box and evalute volume
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Box {
	double width;
	double height;
	double depth;

	Box(double w, double h, double d) {
		System.out.println("Constructing Box");
		this.width = w;
		this.height = h;
		this.depth = d;
	}
//    void setDim(double w,double h,double d) {
//        width = w;
//        height = h;
//        depth = d;
//    }

	double volume() {
		return width * height * depth;
	}

	protected void finalize() {
		System.out.println("I am destroyed");
	}
}

public class Method {
	public static void main(String[] args) {
		Box myBox1 = new Box(10, 20, 15);
		Box myBox2 = new Box(3, 6, 9);

//        myBox1.setDim(10,20,15);
//        myBox2.setDim(3,6,9);

		System.out.println("The Volume is " + myBox1.volume());
		System.out.println("The Volume is " + myBox2.volume());
		myBox1 = null;
		myBox2 = null;
		System.gc();
	}
}
