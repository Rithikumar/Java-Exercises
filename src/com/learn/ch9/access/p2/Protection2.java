package com.learn.ch9.access.p2;

class Protection2 extends com.learn.ch9.access.p1.Protection {
	Protection2() {
		System.out.println("derived other package constructor");
// class or package only
// System.out.println("n = " + n);
// class only
// System.out.println("n_pri = " + n_pri);
		System.out.println("n_pro = " + n_pro);
		System.out.println("n_pub = " + n_pub);
	}
}

class OtherPackage {
	OtherPackage() {
		com.learn.ch9.access.p1.Protection p = new com.learn.ch9.access.p1.Protection();
		System.out.println("other package constructor");
		
		// class or package only
		// System.out.println("n = " p.n);
		
		// class only
		// System.out.println("n_pri = " + p.n_pri);
		
		// class, subclass or package only
		// System.out.println("n_pro = " + p.n_pro);
		
		System.out.println("n_pub = " + p.n_pub);
	}
}