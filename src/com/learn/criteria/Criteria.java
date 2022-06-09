package com.learn.criteria;

import java.util.Stack;

public class Criteria {

	private Stack<Object> criteria = new Stack<>();
	
	public Criteria() {};

	public Criteria(String field, Operator operator, Object value) {
		criteria.add(new Criterian(field, operator, value));
	}
	
	public Criteria(Criterian c) {
		criteria.add(c);
	}

	public Criteria and(String field, Operator operator, Object value) {
		return and(new Criterian(field, operator, value));
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
}
