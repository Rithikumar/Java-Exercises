package com.learn.ch5.iteration;

/**
 * <p>
 * The sum of the numbers in the array is evaluated using for each loop
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class ForEach {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum = 0;
		class Inner{
			int s;
			
			Inner(int s){
				this.s = s;
			}
		}
		Inner[] s1 = {new Inner(4) , new Inner(3) , new Inner(2)};
		for (Inner x : s1) {
			System.out.println("Value is: " + x.s);
			x.s++;
		}
		System.out.println(s1[0].s);

	}
}
