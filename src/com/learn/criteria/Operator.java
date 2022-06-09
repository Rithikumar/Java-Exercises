package com.learn.criteria;

public enum Operator {
	EQUAL(0),
	NOT_EQUAL(1),
	GREATER_THAN(2),
	LESSER_THAN(3);
	
	private Integer operator;
	
	private Operator(Integer operator) {
		this.operator = operator;
	}
	
	public static String getString(Operator comparator) {
		return getString(comparator.getValue());
	}
	
	public static String getString(Integer comparator) {
		switch(comparator) {
		case 0:
			return " = " ;
		case 1:
			return " != " ;
		case 2:
			return " > " ;
		case 3: 
			return " < " ;
		default:
			return null;
		}
	}
	
	public Integer getValue() {
		return operator;
	}
}
