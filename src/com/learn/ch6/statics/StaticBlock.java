package com.learn.ch6.statics;

/**
 * <p>A simplest block level static explanation</p>
 * @author rithi-zstch1028
 *
 */
public class StaticBlock {
//	static {
//		System.out.println("Who asked");
//	}
	static int num = 14;
	static {
		System.out.println("I am first");
		System.out.println(num);
	}
	static {
		System.out.println("I am first ");
		System.out.println(num);
	}
	//As we mostly know that main , is the first method in our progra,,am
	public static void main(String[] args) {
		System.out.println("hello there");
	}
//	static {
//		System.out.println("Help");
//	}
}

