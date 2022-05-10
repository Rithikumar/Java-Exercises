package com.learn.ch4.bitwise;

/**
 * <p>
 * Class in which right shift is practiced and experimented on
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class MultByTwo {
	public static void main(String[] args) {
		int i;
		long num = 1;
		int nu = 66;

		for (i = 2; i < 70; i++) {
			num = num << 1;
			System.out.println(i + " = " + num);
		}
		long num3 = 4611686018427387904L;
		System.out.println(num3 << 3);// no modulo taken
		long num2 = 1;
		System.out.println(num2 << 66);// modulo taken
	}
}
