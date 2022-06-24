package com.learn.ch17;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {
	public static void main(String[] args) {
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(-8);
		l2.add(-20);
		l2.add(20);
		l2.add(8);
		l2.add(-6);
		l2.add(6);
		
		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(l2,r);
		for(int i : l2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Collections.shuffle(l2);
		
		System.out.println("List shuffled: ");
		for(int i : l2)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Max : " + Collections.max(l2));
		System.out.println("Min : " + Collections.min(l2));
	}

}
