package com.learn.criteria;

public class Criterian {
	String field;
	Operator operator;
	Object value;
	
	public Criterian(String field, Operator operator , Object value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
	}
	
	public String getExpression() {
		String result = field + Operator.getString(operator) + value;
		return result;
	}
}
