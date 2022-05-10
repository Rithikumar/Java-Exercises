package com.learn.ch3.primitive.integer.longs;

/**
 * <p>
 * Class in which the distance traveled by light is found using datatype long
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Light {
	public static void main(String[] args) {
		int lightspeed;// both lightspeed and days are within the range of int thus, int is used
		int days;
		long seconds;// long is used here as the value of second and distance is higher than
						// integer's range
		long distance;
		lightspeed = 186000;
		days = 1000;
		seconds = days * 24 * 60 * 60;// automatically promoted to long
		distance = lightspeed * seconds;
		System.out.print("In " + days);
		System.out.print(" days light will travel about ");
		System.out.print(distance + " miles.");
	}
}
