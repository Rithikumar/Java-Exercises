package com.formulas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class Controller extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String formulaName;
	private String formulaExpression;
	private JSONObject obj = new JSONObject();

	public String getFormulaExpression() {
		return formulaExpression;
	}

	public void setFormulaExpression(String formulaExpression) {
		this.formulaExpression = formulaExpression;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}
	
	public void getFormulas() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Formulas f = new Formulas();
		obj = f.getFormulas();
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

	public void addFormula() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Formulas f = new Formulas();
		obj = f.addFormula(getFormulaName(), getFormulaExpression());
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

	public void editFormula() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		Formulas f = new Formulas();
		obj = f.editFormula(formulaName, formulaExpression);
		PrintWriter out = response.getWriter();
		out.println(obj);

	}
	
	public void deleteFormula() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		Formulas f = new Formulas();
		obj = f.deleteFormula(formulaName);
		PrintWriter out = response.getWriter();
		out.println(obj);
	}
	
	public void check() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Formulas f = new Formulas();
		obj = f.check();
		PrintWriter out = response.getWriter();
		out.println(obj);
	}
}
