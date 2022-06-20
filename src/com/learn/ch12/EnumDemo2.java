package com.learn.ch12;

enum Apple1 {
	Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumDemo2 {
	public static void main(String[] args) {
		Apple1 ap;
		
		System.out.println("Here are all Apple constants: ");
		
		//use values()
		
		Apple1 allapples[] = Apple1.values();
		
		for(Apple1 a : allapples) {
			System.out.println(a);
		}
		
		System.out.println();
		
		//use valueOf()
		ap = Apple1.valueOf("Winesap");
		System.out.println("ap contains " + ap);
	}
}
