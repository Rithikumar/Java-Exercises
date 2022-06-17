package com.learn.criteria;

import java.util.HashMap;

public class Criterian {
	Object field;
	Operator operator;
	Object value;
	Object value2;

	public Criterian(String field, Operator operator, String value, String value2) {
		this.field = field;
		this.operator = operator;
		this.value = value;
		this.value2 = value2;
	}

	public Criterian(String field, Operator operator, String value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
		this.value2 = null;
	}

	public Criterian(String field, Operator operator) {
		this.field = field;
		this.operator = operator;
		this.value = null;
		this.value2 = null;
	}

	public String getExpression() {
		String result = "";
		if(operator.getValue() == 5) {
			result = field + Operator.getString(operator);
		}
		else {
		if (value2 != null) {
			result = field + Operator.getString(operator) + value;
			result += " , " + value2;
		}
		}
		return result;
	}

	public static boolean isDecimal(String value) {
		if (value.contains(".")) {
			return false;
		}
		return true;
	}

	public static boolean evaluate(Criterian c, HashMap<String, Object> map) throws Exception {
		boolean result = false;
		String fie = ((String) c.field).trim();
		String op = Operator.getString(c.operator);
		Object key = map.get(fie);
		String val = null;
		Object value = null;
		
		if (c.operator.getValue() != 5) {
			val = ((String) c.value).trim();
			value = map.get(val);
			val = val.substring(1, val.length() - 1);
			fie = fie.substring(1, fie.length() - 1);
		}
		try {
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

			case " BETWEEN ":
				// code here
				String val2 = ((String) c.value2).trim();
				Object value2 = map.get(val2);
				val2 = val2.substring(1, val2.length() - 1);
				if (key == null) {
					if (value == null) {
						if (value2 == null) {
							result = (Double.parseDouble(fie) > Double.parseDouble(val))
									&& (Double.parseDouble(fie) < Double.parseDouble(val2));
						} else {
							result = (Double.parseDouble(fie) > Double.parseDouble(val))
									&& (Double.parseDouble(fie) < Double.parseDouble((String) value2));
						}
					} else {
						if (value2 == null) {
							result = (Double.parseDouble(fie) > Double.parseDouble((String) value))
									&& (Double.parseDouble(fie) < Double.parseDouble(val2));
						} else {
							result = (Double.parseDouble(fie) > Double.parseDouble((String) value))
									&& (Double.parseDouble(fie) < Double.parseDouble((String) value2));
						}
					}
				} else {
					if (value == null) {
						if (value2 == null) {
							result = (Double.parseDouble((String) key) > Double.parseDouble(val))
									&& (Double.parseDouble((String) key) < Double.parseDouble(val2));
						} else {
							result = (Double.parseDouble((String) key) > Double.parseDouble(val))
									&& (Double.parseDouble((String) key) < Double.parseDouble((String) value2));
						}
					} else {
						if (value2 == null) {
							result = (Double.parseDouble((String) key) > Double.parseDouble((String) value))
									&& (Double.parseDouble((String) key) < Double.parseDouble(val2));
						} else {
							result = (Double.parseDouble((String) key) > Double.parseDouble((String) value))
									&& (Double.parseDouble((String) key) < Double.parseDouble((String) value2));
						}
					}
				}
				break;
				
			case " EXISTS ":
				if (fie.contains("\"")) {
					// if the double quote is not close or not opened throws an exception
					if ((fie.charAt(0) == '"' && fie.charAt(fie.length() - 1) == '"')) {
						fie = fie.substring(1, fie.length() - 1);
						return map.containsKey(fie);
					}
				}else {
					return map.containsKey(fie);
				}
			}
		} catch (NumberFormatException e) {
			throw new Exception("String is not supported for this operations");
		}
		return result;
	}
}
