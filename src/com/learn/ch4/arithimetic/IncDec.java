package com.learn.ch4.arithimetic;

/**
 * <p>
 * The increment and decrement operators are experimented here
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class IncDec {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c;
		int d;
		c = ++b;
		d = a++;
		c++;
		int e = a++ + c++;// a + c (2+4)
		float f = 5.43f;
		f++;
		int b1 = 4;
		b1 += b1++ + ++b1; // 4+= 4 + 6 == 14
		int c2 = 1;
		c2 = 1 + (c2++);// parenthesis doesn't change the value
		byte v = 127;
		v++;
		System.out.println(v);
		System.out.println(c2);
		System.out.println(f);
		System.out.println(e);
		System.out.println(b1);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println(f);
	}
}
