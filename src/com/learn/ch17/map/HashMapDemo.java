package com.learn.ch17.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String, Double> hm = new HashMap<String, Double>();
		
		hm.put("John Doe", 3434.34);
		hm.put("Tom Smith", 134.22);
		hm.put("Jane Baker", 1334.34);
		hm.put("Tod Hall", 99.22);
		hm.put("Ralph Smith", -34.34);
		
		Set<Map.Entry<String,Double>> se = hm.entrySet();
		
		for(Map.Entry<String, Double> me : se) {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		
		System.out.println();
		
		double balance = hm.get("John Doe");
		hm.put("John Doe", balance + 1000);
		
		System.out.println("John Doe's new balance: " + 
		hm.get("John Doe"));
	}

}
