package com.learn.ch5.Selection;

/**
 * <p>
 * Implementation of switch statements and the using of breaks to get desirable
 * output
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class SampleSwitch {
	public static void main(String[] args) {
		// normal switch statement
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				System.out.println("i is zero.");
				break;
			case 1:
				System.out.println("i is one.");
				break;
			case 2:
				System.out.println("i is two.");
				break;
			case 3:
				System.out.println("i is three.");
				break;
			default:
				System.out.println("i is greater than 3.");
				break;
			}
		}
		// no break
		for (int i = 0; i < 12; i++) {
			switch (i) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println("i is less than 5");
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("i is less than 10");
				break;
			default:
				System.out.println("i is 10 or more");
			}
		}
	}
}
