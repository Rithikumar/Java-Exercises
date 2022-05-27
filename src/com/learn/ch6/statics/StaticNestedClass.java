package com.learn.ch6.statics;

class OuterClass {
	static class inner {
		void displahy() {
			System.out.println("Check");
		}
	}
}

public class StaticNestedClass {
	
	public static void main(String[] args) {
		
		OuterClass.inner as = new OuterClass.inner();
		as.displahy();
	}
	
	static {
		System.out.println("hi");
	}
}
