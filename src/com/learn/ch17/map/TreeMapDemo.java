package com.learn.ch17.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		tm.put("John Doe", 3434.34);
		tm.put("Tom Smith", 134.22);
		tm.put("Jane Baker", 1334.34);
		tm.put("Tod Hall", 99.22);
		tm.put("Ralph Smith", -34.34);
		
		Set<Map.Entry<String, Double>> set = tm.entrySet();
		
		for(Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		
		double balance = tm.get("John Doe");
		tm.put("John Doe", balance + 1000);
		
		System.out.println("John Doe's new balance : " + tm.get("John Doe"));
	}
}
