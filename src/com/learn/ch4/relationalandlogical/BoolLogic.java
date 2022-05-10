package com.learn.ch4.relationalandlogical;

/**
 * <p>
 * Relational operators are practiced here
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BoolLogic {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c = a | b;
		boolean d = a & b;
		boolean e = a ^ b;
		boolean f = (!a & b) | (a & !b);
		boolean g = !a;
		boolean h = a | b & a ^ b | !a;
		System.out.println(null instanceof Object);// tru
		System.out.println(h);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a|b = " + c);
		System.out.println("a&b = " + d);
		System.out.println("a^b = " + e);
		System.out.println("!a&b|a&!b = " + f);
		System.out.println("!a = " + g);
	}
}
