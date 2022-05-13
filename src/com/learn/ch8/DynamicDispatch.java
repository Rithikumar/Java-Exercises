package com.learn.ch8;

class L {
	void callme() {
		System.out.println("Inside L's callme method");
	}
}

class M extends L {
	void callme() {
		System.out.println("Inside M's callme method");
	}
}

class N extends L {
	void callme() {
		System.out.println("Inside N's callme method");
	}
}

public class DynamicDispatch {
	public static void main(String[] args) {
		L a = new L();
		M b = new M();
		N c = new N();
		
		a.callme();
		b.callme();
		c.callme();
	}

}
