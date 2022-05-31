package com.learn.ch6.statics;

class OuterClass {
	static class Inner {
		void displahy() {
			System.out.println("Check");
		}
	}
}

public class StaticNestedClass {
	
	public static void main(String[] args) {
		java.util.HashMap<String,String> m = new java.util.HashMap<>();
		OuterClass.Inner as = new OuterClass.Inner();
		as.displahy();
		
	}
	
	static {
		System.out.println("hi");
	}
}
