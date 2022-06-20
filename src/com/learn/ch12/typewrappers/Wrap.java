package com.learn.ch12.typewrappers;

public class Wrap {
	public static void main(String[] args) {
		Integer iOb = new Integer(100);
		int i = iOb.intValue();
		System.out.println(i + " " + iOb);
		
		Integer iOb1 = 1000; // autobox the value 1000
		int i2 = iOb1.byteValue(); // manually unbox as byte !!!
		System.out.println(i2); // does not display 1000 !
	}
}
