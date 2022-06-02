package com.learn.ch8.types;

class A implements Cloneable {
	int a;
	int b;

	A(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
    protected A clone()
        throws CloneNotSupportedException
    {
        return (A) super.clone();
    }
}

public class SampleClone{
	public static void main(String[] args) throws CloneNotSupportedException {
		A a1 = new A(22,11);
		A a2 = a1.clone();
		System.out.println(a2.a+" "+a2.b);
	}
}
