package com.learn.ch4.relationalandlogical;

/**
 * <p>
 * Different types of usage of assignment operators
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class AssignmentOp {

	public static void main(String[] args) {
		int x, y, z;
		x = y = z = 100;
		// int x1 = int y1 = int z1 = 100; invalid
		int x1, y1, z1 = 100;// x1,y1 is not initialized nut z1 is set to 100
		int x2 = x = y = 4 & 2;
		System.out.println(x2 + " " + x + " " + y);
		int ratio = 4 == 0 ? 0 : 1;
		System.out.println(ratio);
		int multi = x < 2 ? (y == 3 ? 1 : (x < 0 ? 2 : 3)) : 4;
		// to if else
		if (x < 2) {
			if (y == 3) {
				System.out.println(1);
			} else {
				if (x < 0) {
					System.out.println(2);
				} else {
					System.out.println(3);
				}
			}
		} else {
			System.out.println(4);
		}
		System.out.println(multi);
	}
}
