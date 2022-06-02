package com.learn.ch8.types;

class Parent{
	int a,b,c;
	private int d = 4;
		
	Parent(int a){
		System.out.println("Type 1");
		this.a  = a;
		c = b = 0;
	}
	
	Parent(int a, int b){
		System.out.println("Type 2");
		this.a = a ;
		this.b = b;
		c = 0;
	}
}

class Child extends Parent{
	int w,y,z;
	
	Child(){
		// System.out.println(super.d); // can't acess
		super(1,2);
	}
}

public class SuperConstructor {
	public static void main(String[] args) {
		Child c  = new Child();
		System.out.println(c.a);
	}
}
