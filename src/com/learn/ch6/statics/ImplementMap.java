package com.learn.ch6.statics;

import java.util.HashMap;

public class ImplementMap {
	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<String,Object>();
	
		map.put("num1", 4);
		map.put("num2", 4.3);
		map.put("num3", "hi");
		map.put("num4", 4L);
		map.put("num5", false);
		for(String a : map.keySet()) {
			System.out.println(a+" = "+map.get(a));
		}
		System.out.println(map.toString());
		System.out.println(map.containsKey("num3"));
		System.out.println(map.containsValue("44"));
	}
}
