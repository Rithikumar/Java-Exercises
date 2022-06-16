package com.learn.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Criteria {

	private Stack<Object> criteria = new Stack<>();
	
	public Criteria() {};

	public Criteria(String field, Operator operator, String value) {
		criteria.add(new Criterian(field, operator, value));
	}
	
	public Criteria(Criterian c) {
		criteria.add(c);
	}

	public Criteria and(String field, Operator operator, String value) {
		return and(new Criterian(field, operator, value));
	}
	
	public Criteria not(Object crt) {
		criteria.add("!");
		criteria.add("(");
		criteria.add(crt);
		criteria.add(")");
		return this;
	}

	public Criteria and(Criterian criterian) {
		if (!criteria.isEmpty()) {
			criteria.add(" AND ");
		}
		criteria.add(criterian);
		return this;
	}

	public Criteria and(Criteria crt) {
		if(!crt.criteria.isEmpty()) {
			if(!criteria.isEmpty()) {
				criteria.add(" AND ");
			}
			criteria.add(" ( ");
			criteria.add(crt);
			criteria.add(" ) ");
		}
		return this;
	}
	
	public Criteria notAnd(Object obj) {
		criteria.add(" AND ");
		criteria.add("!");
		criteria.add("(");
		criteria.add(obj);
		criteria.add(")");
		return this;
	}
	
	public Criteria or(Criterian criterian) {
		if (!criteria.isEmpty()) {
			criteria.add(" OR ");
		}
		criteria.add(criterian);
		return this;
	}

	public Criteria or(Criteria crt) {
		if(!crt.criteria.isEmpty()) {
			if(!criteria.isEmpty()) {
				criteria.add(" OR ");
			}
			criteria.add(" ( ");
			criteria.add(crt);
			criteria.add(" ) ");
		}
		return this;
	}
	
	public Criteria notOr(Object obj) {
		criteria.add(" OR ");
		criteria.add("!");
		criteria.add("(");
		criteria.add(obj);
		criteria.add(")");
		return this;
	}
	
	public String toString() {
		return this.criteria.toString();
	}
	
	public String getCriteriaString() {
		StringBuffer buf = new StringBuffer();
		for (Object crt : criteria) {
//			Logger.info(crt);
			if(crt instanceof Criteria) {
				Criteria criteria = (Criteria) crt;
				if(!criteria.criteria.isEmpty()) {
					buf.append(criteria.getCriteriaString());
				}
			} else if (crt instanceof Criterian) {
				buf.append(((Criterian)crt).getExpression());
			} else if (crt instanceof String) {
				buf.append(crt);
			}
		}
		return buf.toString();
	}
	
	public static boolean evaluate(Criteria c , HashMap<String,Object> map) throws Exception {
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		ArrayList<String> condition = new ArrayList<String>();
		for(int i = 0 ; i < c.criteria.size() ; i++) {
			Object crt = c.criteria.get(i);
			if(crt instanceof Criterian) {
				Criterian cri = (Criterian) crt;
				result.add(Criterian.evaluate(cri, map));
			}
			else if (crt instanceof Criteria) {
				Criteria criteria = (Criteria) crt;
				if(!criteria.criteria.isEmpty()) {
					if(i != 0 && i != 1) {
						if(c.criteria.get(i-2).equals("!")) {
							result.add(!(Criteria.evaluate((Criteria)crt, map)));
						}
						else {
							result.add(Criteria.evaluate((Criteria)crt, map));
						}
					}
					else {
						result.add(Criteria.evaluate((Criteria)crt, map));
					}
				}
			}
			else if (crt instanceof String) {
				String stringOpe = ((String)crt);
				if(stringOpe.equals(" AND ") || stringOpe.equals(" OR ")) {
					condition.add(stringOpe);
				}
			}
		}
		boolean finalResult = false;
		for(int i = 0 ; i < result.size() ; i ++) {
			boolean a = result.get(i);
			if(i == 0) {
				finalResult = a;
			}
			else {
				if(condition.get(i-1).equals(" AND ")) {
					finalResult = finalResult && a;
				}
				else if(condition.get(i-1).equals(" OR ")){
					finalResult = finalResult || a;
				}
			}
		}
		return finalResult;
	}
}
