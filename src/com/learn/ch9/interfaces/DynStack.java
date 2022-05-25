package com.learn.ch9.interfaces;

/**
 * <p>Implement a growable stack.</p>
 * @author rithi-zstch1028
 *
 */
public class DynStack implements IntStack{
	private int[] stck;
	private int tos;
	
	//allocate and initialize stack 
	DynStack (int size) {
		stck = new int[size];
		tos = -1;
	}
	
	//Push an item onto the stack
	public void push(int item) {
		//if stack is full , allocate a larger stack
		if(tos == stck.length -1) {
			int temp[] = new int[stck.length * 2];
			for(int i = 0 ; i < stck.length ; i++) temp[i] = stck[i];
			stck = temp;
			stck[++tos] = item;
		}
		else
			stck[++tos] = item;
	}
	
	// Pop an item from the stack
	public int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else 
			return stck[tos--];
	}
}
