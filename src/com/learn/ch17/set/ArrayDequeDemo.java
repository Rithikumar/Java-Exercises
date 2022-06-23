package com.learn.ch17.set;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
	public static void main(String[] args) {
		ArrayDeque<String> ad = new ArrayDeque<String>();
		ad.push("A");
		ad.push("B");
		ad.push("D");
		ad.push("E");
		ad.push("F");
		ad.push("G");
		
		System.out.println("Popping the stack: ");
		while(ad.peek() != null) {
			System.out.print(ad.pop() + " ");
		}
		
		System.out.println();
	}
}
