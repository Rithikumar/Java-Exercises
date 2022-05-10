package com.learn.ch7;

/**
 * <p>This class defines an integer stack that can hold 10 values</p>
 * @author rithi-zstch1028
 *
 */
public class ImprovedStack {
	
	private int[] stck = new int[10];
	private int tos;
	
	//Initialize top of stack
	ImprovedStack() {
		tos = -1;
	}
	
	//Push an item onto the stack
	void push(int item) {
		if(tos == 9)
			System.out.println("Stack is full");
		else
			stck[++tos] = item;
	}
	
	int pop() {
		if(tos < 0) {
			System.out.println("stack underflow");
			return 0;
		}
		else
			return stck[tos--];
	}
}
