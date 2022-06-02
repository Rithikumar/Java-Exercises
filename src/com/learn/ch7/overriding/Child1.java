package com.learn.ch7.overriding;

public class Child1 extends Parent1 {
	int a;
	int b = 30;

	@Override
	public void sub(int a , int b) {
		super.add();
		super.sample();
		System.out.println();
	}
	
	public void sample(int a) {
		System.out.println("Hello");
	}
	
	public static void ex() {
		System.out.println("Child example");
	}
	
	public static void main(String[] args) {
		Parent1 p = new Child1();
		System.out.println(p.b);
		// p.sample(1); //Throws error as parent sample is not overriden by the child
		p.sample();
		p.ex();
		
	}
}
