package com.learn.ch8;

//class Objects{
//	int dummy;
//	
//	Objects(int num){
//		dummy = num;
//	}
//	
//	void read() {
//		System.out.println(dummy);
//	}
//}

public class SampleObject {
		
	public static void main(String[] args) {
		Object n = new Object();
		Object n1 = new Object();
	
		System.out.println(n.equals(n1));
		System.out.println(n.getClass());
		System.out.println(n.hashCode());
		//n.notify();
	}
}
