package com.learn.ch6;

/**
 * <p>
 * A Class which used as to evaluate volume of box
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BoxDemo {
	public static void main(String[] args) {
		Box myBox = new Box(10,20,15);
		Box myBox2 = new Box(3,6,9);
		double vol;

		myBox.width = 10;
		myBox.height = 20;
		myBox.depth = 15;

		myBox2.width = 3;
		myBox2.height = 6;
		myBox2.depth = 9;

		vol = myBox.width * myBox.height * myBox.depth;
		System.out.println("The Volume is " + vol);

		vol = myBox2.width * myBox2.height * myBox2.depth;
		System.out.println("The Volume is " + vol);

	}
}
