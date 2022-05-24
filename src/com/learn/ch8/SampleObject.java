package com.learn.ch8;

class Objects implements Cloneable{
	int dummy;
	
	Objects(int num){
		dummy = num;
	}
	
	void read() {
		System.out.println(dummy);
	}
}

public class SampleObject {
		
	public static void main(String[] args) {
		Objects n = new Objects(3);
		Object n1 = new Object();
		String s1= new String("Ashok");
		//Object n3 = n.cl;
		//Object n4 = n3;
		System.out.println(n.equals(n1));
		System.out.println(n.getClass());
		System.out.println(n.hashCode());
		//n.notify();
	}
}
