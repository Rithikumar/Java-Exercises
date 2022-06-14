package com.learn.criteria;

import java.util.HashMap;

public class Criterian {
	Object field;
	Operator operator;
	Object value;

	public Criterian(String field, Operator operator, String value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	public String getExpression() {
		String result = field + Operator.getString(operator) + value;
		return result;
	}

	public static boolean isDecimal(String value) {
		if (value.contains(".")) {
			return false;
		}
		return true;
	}

	public static boolean evaluate(Criterian c, HashMap<String, Object> map) {
		boolean result = false;
		String fie = ((String) c.field).trim();
		String val = ((String) c.value).trim();
		String op = Operator.getString(c.operator);
		Object key = map.get(fie);
		Object value = map.get(val);
		fie = fie.substring(1, fie.length() - 1);
		val = val.substring(1, val.length() - 1);
		
		switch (op) {
		case " = ":
			if (key == null) {
				if (value == null) {
					result = fie.equals(val);
				} else {
					result = fie.equals(value);
				}
			} else {
				if (value == null) {
					result = (key.equals(val));
				} else {
					result = key.equals(value);
				}
			}
			break;

		case " != ":
			if (key == null) {
				if (value == null) {
					result = !(fie.equals(val));
				} else {
					result = !(fie.equals(value));
				}
			} else {
				if (value == null) {
					result = !(key.equals(val));
				} else {
					result = !(key.equals(value));
				}
			}
			break;

		case " > ":

			if (key == null) {
				if (value == null) {
					result = Double.parseDouble(fie) > Double.parseDouble(val);
				} else {
					result = Double.parseDouble(fie) > Double.parseDouble((String) value);
				}
			} else {
				if (value == null) {
					result = Double.parseDouble((String) key) > Double.parseDouble(val);
				} else {
					result = Double.parseDouble((String) key) > Double.parseDouble((String) value);
				}
			}
			break;

		case " < ":

			if (key == null) {
				if (value == null) {
					result = Double.parseDouble(fie) < Double.parseDouble(val);
				} else {
					result = Double.parseDouble(fie) < Double.parseDouble((String) value);
				}
			} else {
				if (value == null) {
					result = Double.parseDouble((String) key) < Double.parseDouble(val);
				} else {
					result = Double.parseDouble((String) key) < Double.parseDouble((String) value);
				}
			}
			break;

		}
		return result;
	}
}
