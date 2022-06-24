package com.learn.ch17.legacy;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3,2);
		System.out.println("Initial Size: " + v.size());
		System.out.println("Intial capacity: " + v.capacity());
		
		v.addElement(1);
		v.addElement(2);
		v.addElement(3);
		v.addElement(4);
		
		System.out.println("Capacity after four additions: " + v.capacity());
		v.addElement(5);
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(6);
		v.addElement(7);
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(8);
		v.addElement(9);
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(10);
		v.addElement(11);
		System.out.println("First element: " + v.firstElement());
		System.out.println("Last element: " + v.lastElement());
		
		if(v.contains(3))
			System.out.println("Vector contains 3.");
		
		//Enumerate the elements in the vector
		Enumeration vEnum = v.elements();
		System.out.println("\nElements in vector: ");
		while(vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement()+" ");
		}
		System.out.println();
	}
}
