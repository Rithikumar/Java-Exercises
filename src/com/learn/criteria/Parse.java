package com.learn.criteria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Parse {

	public static Object loadFromString(String in) throws Exception {
		String res = "";
		int count = 0;
		Criteria cfinal = new Criteria();
		ArrayList<Object> st = new ArrayList<Object>();
		ArrayList<String> conditions = new ArrayList<String>();
		if (in.contains("(") || in.contains(")")) {
			for (char a : in.toCharArray()) {
				if (a == '(') {
					if (count != 0) {
						res += a;
					} else if (res != "" && st.size() != 0) {
						conditions.add(res);
						res = "";
					}

					count++;
				} else if (a == ')') {
					count--;
					if (count == 0) {
						st.add(loadFromString(res));
						res = "";
					} else {
						res += a;
					}

				} else {
					res += a;
				}
				if(in.indexOf(a) == in.length()-1 && res != "") {
					throw new Exception("brackects not found on " + res);
					
				}
			}
		} else {
			String[] arr = in.split(",");
			Criterian c = null;
			check(arr[0]);
			check(arr[1]);
			if(arr.length == 3) {
			int a = Integer.parseInt(arr[1]);
			switch (a) {
			case 0:
				c = new Criterian(arr[0], Operator.EQUAL, arr[2]);
				break;
			case 1:
				c = new Criterian(arr[0], Operator.NOT_EQUAL, arr[2]);
				break;
			case 2:
				c = new Criterian(arr[0], Operator.GREATER_THAN, arr[2]);
				break;
			case 4:
				c = new Criterian(arr[0], Operator.LESSER_THAN, arr[2]);
				break;
			default:
				throw new Exception("Operator is invalid in ("+arr[0]+","+a+","+arr[1]+")");
			}
			return c;
			}
			else {
				throw new Exception("Parameters invalid in ("+ in +")");
			}
		}
		for (int i = 0; i < st.size(); i++) {
			Object c = st.get(i);
			if (c instanceof Criteria) {
				if (conditions.isEmpty() || i == 0) {
					cfinal = cfinal.and((Criteria) c);
				} else {
					if (conditions.get(i-1).contains("and")) {
						cfinal = cfinal.and((Criteria) c);
					} else if (conditions.get(i-1).contains("or")){
						cfinal = cfinal.or((Criteria) c);
					}
					else {
						throw new Exception("Joining type is invalid");
					}
				}

			} else if (c instanceof Criterian) {
				if (conditions.isEmpty() || i == 0) {
					cfinal = cfinal.and((Criterian) c);
				} else {
					if (conditions.get(i-1).contains("and")) {
						cfinal = cfinal.and((Criterian) c);
					}  else if (conditions.get(i-1).contains("or")){
						cfinal = cfinal.or((Criterian) c);
					}
					else {
						throw new Exception("Joining type is invalid");
					}
				}
			}
		}
		if(res != "") {
			throw new Exception("Invalid format");
		}

		return cfinal;

	}
	
	public static void check(String toCheck) throws Exception {
		if(toCheck.contains("\"")){
			if(!(toCheck.charAt(0) == '"' && toCheck.charAt(toCheck.length()-1) == '"')){
				throw new Exception("Improper value assigning in "+toCheck);
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter string: ");
		String in = new Scanner(System.in).nextLine();
		// System.out.println(((Criteria) recur(in)).toString());
		try {
			Object result =  loadFromString(in);
			if(result instanceof Criteria) {
				System.out.println(((Criteria) result).getCriteriaString());
			}
			else {
				System.out.println(((Criterian) result).getExpression());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
