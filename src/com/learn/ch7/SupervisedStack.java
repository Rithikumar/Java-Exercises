package com.learn.ch7;

/**
 * <p>
 * Super improved stack
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class SupervisedStack {
	private int stck[];
	private int tos;

	SupervisedStack(int size) {
		stck = new int[size];
		tos = -1;
	}

	void push(int item) {
		if (tos == stck.length - 1)
			System.out.println("Stack is full");
		else
			stck[++tos] = item;
	}

	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else
			return stck[tos--];
	}
	
	public static void main(String args[]) {
		String[] colors = new String[3];
		colors[0] = "red";
		colors[1] = "blue";
		colors[2] = "black";
		String[] colors1 = {"red","blue","black"};
		int[] num = {0,1,2,3};
	}
}
