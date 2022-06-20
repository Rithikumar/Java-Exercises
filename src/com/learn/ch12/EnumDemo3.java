package com.learn.ch12;

enum Apple3{
	Jonathan(10), GoldenDel(9) , RedDel(12) , Winesap(15) , Cortland(8);
	
	private int price;
	
	Apple3(int p) { price = p;}
	
	int getPrice() {return price;}
	
}

public class EnumDemo3 {
	public static void main(String[] args) {
		Apple3 ap;
		
		System.out.println("Winesap costs " + Apple3.Winesap.getPrice() + " cents");
		
		System.out.println("All apple prices: ");
		for(Apple3 a : Apple3.values())
			System.out.println(a + " costs " + a.getPrice() + " cents.");
	}
}
