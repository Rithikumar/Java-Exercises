package com.learn.ch8;

class J {
	int i, j;

	J(int a, int b) {
		i = a;
		j = b;
	}

	void show() {
		System.out.println("i and j " + i + " " + j);
	}
}

class K extends J {
	int k;

	K(int a, int b, int c) {
		super(a, b);
		k = c;
	}

	void show(String message) {
		System.out.println(message + k);
	}
}

public class Override {
	public static void main(String[] args) {
		K subo = new K(1,2,3);
		subo.show("This is k:");
		subo.show();
		
	}
}
