package com.learn.ch6;

import java.util.Arrays;

/**
 * <p>
 * This class defines an integer stack that can hold values
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Stack {
	int[] stck = new int[10];
	int tos;

	// Intialize top-of-stack
	Stack() {
		tos = -1;
	}

	// Push an item onto the stack
	void push(int item) {
		if (tos == 9)
			System.out.println("Stack is full");
		else
			stck[++tos] = item;
	}

	// Pop an item from the stack
	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else
			return stck[tos--];
	}
}

/**
 * <p>
 * Used to check the stack class
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class TestStack {

	public static void main(String[] args) {
		Stack myStack1 = new Stack();
		Stack myStack2 = new Stack();
		System.out.println(Arrays.toString(myStack1.stck));
		// push some numbers onto the stack
		for (int i = 0; i < 10; i++)
			myStack1.push(i);
		for (int i = 10; i < 20; i++)
			myStack2.push(i);
		System.out.println(Arrays.toString(myStack1.stck));
		System.out.println(Arrays.toString(myStack2.stck));
		// pop those numbers off the stack
		System.out.print("Stack in myStack1: ");
		for (int i = 0; i < 10; i++)
			System.out.print(myStack1.pop() + " ");
		System.out.print("\nStack in myStack2: ");
		for (int i = 0; i < 10; i++)
			System.out.print(myStack2.pop() + " ");
	}
}
