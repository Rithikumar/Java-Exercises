package com.learn.ch8;

/**
 * <p>
 * The class is used see how a reference object is shared between subclass and
 * superclass
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class RefDemo {
	public static void main(String[] args) {
		BoxWeight weightBox = new BoxWeight(3, 5, 6, 8.37);// Initializing weightBox
		Box plainBox = new Box();// Initializing bis
		double vol;

		vol = weightBox.volume();
		// check the value of weightbox here
		System.out.println("Volume of weightBox is " + vol);
		System.out.println("Weight of weightBox is " + vol);
		System.out.println();

		plainBox = weightBox;
		// assigning weightbox object to plainbox
		vol = plainBox.volume();
		// method present is plainbox is accessible
		System.out.println("Volume is plainbox is " + vol);
		// here error is thrown as the box class not access.weight
		// System.out.println("Weight of plainbox is " + plainbox.weight);
	
		Box plainBox1 = new BoxWeight(2,3,4,5);
		//the object is created but value is not initialized
		plainBox1.depth = 12;
		System.out.print(plainBox1.depth);
	}
}
