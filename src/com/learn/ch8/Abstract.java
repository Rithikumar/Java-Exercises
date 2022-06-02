package com.learn.ch8;

/**
 * <p>A simple demonstration abstract</p>
 * @author rithi-zstch1028
 *
 */
abstract class O{
	void callme() {};
	
	//concrete methods are still allowed in abstract classes
	void callmetoo() {
		System.out.println("This is a concrete method");
	}
}
class P extends O {
	@Override
	void callme() {
		System.out.println("N is implementation of callme");
	}

}

public class Abstract {
	public static void main(String[] args) {
		P p = new P();
		p.callme();
		p.callmetoo();
	}
}
