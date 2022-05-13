package com.learn.ch8;

class G{
	G() {
		System.out.println("Inside G's constructor");
	}
}

class H extends G {
	H() {
		System.out.println("Inside H's constructor");;
	}
}

class I extends H {
	I() {
		System.out.println("Inside I's constructor");;
	}
}

public class CallingCons {
	public static void main(String[] args) {
		I i = new I();
	}
}
