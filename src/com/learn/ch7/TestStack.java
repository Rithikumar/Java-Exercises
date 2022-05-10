package com.learn.ch7;

public class TestStack {
	public static void main(String[] args) {
		ImprovedStack mystack1 = new ImprovedStack();
		ImprovedStack mystack2 = new ImprovedStack();
		// push some numbers onto the stack
		for(int i=0; i<10; i++) mystack1.push(i);
		for(int i=10; i<20; i++) mystack2.push(i);
		// pop those numbers off the stack
		System.out.println("Stack in mystack1:");
		for(int i=0; i<10; i++)
		System.out.println(mystack1.pop());
		System.out.println("Stack in mystack2:");
		
		for(int i=0; i<10; i++)
			System.out.println(mystack2.pop());
			// these statements are not legal
			// mystack1.tos = -2;
			// mystack2.stck[3] = 100;
	}
	
}
