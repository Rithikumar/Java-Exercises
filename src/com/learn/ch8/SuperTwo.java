package com.learn.ch8;

class E {
	int i;
}

class F extends E {
	int i;//This i hides the i in E
	
	F(int a , int b) {
		super.i = a;// i in E
		i = b;// i in F
	}
	
	void show() {
		System.out.println("i in superclass: " + super.i);
		System.out.println("i in subclass: " + i);
	}
}

public class SuperTwo {
	public static void main(String args[]) {
		F subOb = new F(1,2);
		subOb.show();
	}
}
