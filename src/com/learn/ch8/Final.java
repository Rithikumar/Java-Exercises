package com.learn.ch8;

class A1 {
	final void method(String name) {
		System.out.println("This is a final method.");
	}
}

class B1 extends A1 {
//	void method() { Error! can't override
//		System.out.println();
//	}
}

final class A2 {
	void method() {
		System.out.println("name");
	}
}

//class B2 extends A2 {
//	
//}