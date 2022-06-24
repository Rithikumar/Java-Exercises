package com.learn.ch17;

import java.util.Comparator;
import java.util.TreeSet;

class MyComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		return o2.compareTo(o1);
	}
	
}

public class ReverseComparator  {
	
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new MyComp());
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		
		for(String a : ts) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
