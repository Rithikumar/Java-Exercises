package com.learn.ch17.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashsetDemo {
	public static void main(String[] args) {
		HashSet<String> hf = new HashSet<String>();
	
		hf.add("B");
		hf.add("A");
		hf.add("D");
		hf.add("E");
		hf.add("C");
		hf.add("F");
		
		System.out.println(hf);
		
		HashSet<String> hs = new LinkedHashSet<String>();
		
		hs.add("B");
		hs.add("B");
		hs.add("A");
		hs.add("D");
		hs.add("E");
		hs.add("C");
		hs.add("F");
		
		System.out.println(hs);
	}
}
