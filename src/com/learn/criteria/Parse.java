package com.learn.criteria;

import java.util.ArrayList;
import java.util.Scanner;

public class Parse {
	
	private static ArrayList<String> allowedFilterCols = new ArrayList<String>();

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
					} else if (res.equals("!")) {
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
				if (in.indexOf(a) == in.length() - 1 && res != "") {
					throw new Exception("brackects not found on " + res);

				}
			}
		} else {
			String[] arr = in.split(",");
			Criterian c = null;
			if (arr.length == 3) {
				int a = Integer.parseInt(arr[1]);
				check(arr[0]);
				check(arr[2]);
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
					throw new Exception("Operator is invalid in (" + arr[0] + "," + a + "," + arr[1] + ")");
				}
				return c;
			} else {
				throw new Exception("Parameters invalid in (" + in + ")");
			}
		}
		for (int i = 0; i < st.size(); i++) {
			Object c = st.get(i);
			if (c instanceof Criteria) {
				if (i == 0) {
					if (!conditions.isEmpty() && conditions.get(i).equals("!")) {
						cfinal = cfinal.and((Criteria) c);
						conditions.remove(0);
					} else {
						cfinal = cfinal.and((Criteria) c);
					}
				} else {
					if (conditions.get(i - 1).contains("or")) {
						if (conditions.get(i - 1).contains("!")) {
							cfinal = cfinal.notOr(c);
						} else {
							cfinal = cfinal.or((Criteria) c);
						}
					} else if (conditions.get(i - 1).contains("and")) {
						if (conditions.get(i - 1).contains("!")) {
							cfinal = cfinal.notAnd(c);
						} else {
							cfinal = cfinal.and((Criteria) c);
						}
					} else {
						throw new Exception("Joining type is invalid");
					}
				}

			} else if (c instanceof Criterian) {
				if (i == 0) {
					if (!conditions.isEmpty() && conditions.get(i).equals("!")) {
						cfinal = cfinal.not((Criterian) c);
						conditions.remove(0);
					} else {
						cfinal = cfinal.and((Criterian) c);
					}
				} else {
					if (conditions.get(i - 1).contains("and")) {
						if (conditions.get(i - 1).contains("!")) {
							cfinal = cfinal.notAnd((Criterian) c);
						} else {
							cfinal = cfinal.and((Criterian) c);
						}
					} else if (conditions.get(i - 1).contains("or")) {
						if (conditions.get(i - 1).contains("!")) {
							cfinal = cfinal.notOr((Criterian) c);
						} else {
							cfinal = cfinal.or((Criterian) c);
						}
					} else {
						throw new Exception("Joining type is invalid");
					}
				}
			}
		}
		if (res != "") {
			throw new Exception("Invalid format");
		}

		return cfinal;

	}

	public static void check(String toCheck) throws Exception {
		if (toCheck.contains("\"")) {
			if (!(toCheck.charAt(0) == '"' && toCheck.charAt(toCheck.length() - 1) == '"')) {
				throw new Exception("Improper value assigning in " + toCheck);
			}
		}else {
			boolean res = false;
			for(int i = 0 ; i < allowedFilterCols.size() ; i++) {
				if(allowedFilterCols.get(i).equals(toCheck)) {
					res = true;
				}
			}
			if(!res) {
				throw new Exception("Variable name \""+ toCheck +"\" is not in the allowed columns" );
			}
		}
	}

	public static void main(String[] args) {
		allowedFilterCols.add("field1");
		allowedFilterCols.add("field2");
		allowedFilterCols.add("field3");
		allowedFilterCols.add("field4");
		System.out.print("Enter string: ");
		String in = new Scanner(System.in).nextLine();

		try {
			// .out.println(((Criteria) loadFromString(in)).toString());
			Object result = loadFromString(in);
			if (result instanceof Criteria) {
				System.out.println(((Criteria) result).getCriteriaString());
			} else {
				System.out.println(((Criterian) result).getExpression());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
