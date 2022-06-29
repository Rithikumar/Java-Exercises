package com.formulas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.DB.Operations;

public class Formulas {

	private static String recurveCall;
	private JSONObject obj = new JSONObject();
	private static String currentFormulaName;
	private static Map<String, Graphs> formulas;
	private static Map<String, String> expressions = new LinkedHashMap<>();
	private static Map<String, Float> formulasResult = new LinkedHashMap<>();
	
	public static float calc(Nodes n) throws Exception {
		Operations o = new Operations();
        if(n.child.size() == 0)
            try {
                return Float.parseFloat(n.data);
            }
            catch(Exception e){
                if(n.data.equals(currentFormulaName) || n.data.equals(recurveCall)) {
                	formulasResult.remove(n.data);
                    expressions.remove(n.data);
                    formulas.remove(n.data);
                    o.deleteFormula(n.data);
                    throw new Exception("The formula calls it self.");
                }
                else if(formulasResult.containsKey(n.data))
                    return formulasResult.get(n.data);
                else if(formulas.containsKey(n.data)) {
                    Graphs g = formulas.get(n.data);
                    recurveCall = n.data;
                    float res = calc(g.getNode(0));
                    formulasResult.put(n.data, res);
                    o.addResult(n.data, res);
                    return res;
                }
                else if (n.data.contains("(") && n.data.endsWith(")")) {
                	try {
						return Methods.executes(n.data);
					} catch (Exception e1) {
						if(e1.getMessage().contains("not found"))
							throw new Exception("Method not found");
						else
							throw new Exception("Parameters given are invalid");
					}
                }
                else{
                    throw new Exception("Formula name not found.");
                }
            }
        else {
            float left = calc(n.child.get(0));
            float right = calc(n.child.get(1));

            if (n.data.equals("+"))
                return left + right;
            else if (n.data.equals("-"))
                return left - right;
            else if (n.data.equals("*"))
                return left * right;
            else
                return left / right;
        }
    }

    @SuppressWarnings("unchecked")
	public static JSONArray Validate() throws Exception{
    	Operations o = new Operations();
        ArrayList<Map.Entry<String,Graphs>> arr = new ArrayList<>(formulas.entrySet());
        JSONArray arr1 = new JSONArray();
        for(Map.Entry<String,Graphs> map : arr){
            Graphs val = map.getValue();
            JSONObject obj2 = new JSONObject();
            try {
                currentFormulaName = map.getKey();
                float result = calc(val.getNode(0));
                o.addResult(map.getKey(), result);
                obj2.put("formulaName", map.getKey());
                obj2.put("result",result);
            }catch (Exception e){
            	o.deleteFormula(map.getKey());
                obj2.put("formulaName", map.getKey());
                obj2.put("result",e.getMessage());
                e.printStackTrace();
            }
            finally {
            	currentFormulaName = "";
            	recurveCall = "";
            	arr1.add(obj2);
            }
        }
        return arr1;
    }
	
	public static void print(Graphs g){
        for(Nodes n: g.allNodes){
            System.out.print(n.data+" : ");
            for(Nodes n1 : n.child){
                System.out.print("-> "+n1.data);
            }
            System.out.println();
        }
    }
	
	public static void createGraph(String formName, String formExp) {

		Graphs g = new Graphs();
		char[] expression = formExp.toCharArray();
		String operand = "";
		Nodes prevNode = null;
		for (char exp : expression) {
			if (exp == '+' || exp == '-' || exp == '*' || exp == '/') {
				if (g.allNodes.size() == 0) {
					Nodes op = new Nodes(exp + "");
					Nodes opera = new Nodes(operand);
					op.child.add(opera);
					g.addNode(op);
					g.addNode(opera);
					operand = "";
					prevNode = op;
				} else {
					Nodes op = new Nodes(exp + "");
					Nodes opera = new Nodes(operand);
					op.child.add(opera);
					g.addNode(op);
					g.addNode(opera);
					prevNode.child.add(op);
					prevNode = op;
					operand = "";
				}
			} else {
				operand += exp;
			}
		}
		Nodes lastOpera = new Nodes(operand);
		if (g.allNodes.size() == 0) {
			g.addNode(lastOpera);
		} else {
			g.addNode(lastOpera);
			prevNode.child.add(lastOpera);
		}
		formulas.put(formName, g);

	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getFormulas() throws Exception {
		JSONArray arr = new JSONArray();
		Operations o = new Operations();
		expressions = o.getFormulas();
		for (Map.Entry<String, String> map : expressions.entrySet()) {
			JSONObject obj2 = new JSONObject();
			obj2.put("formulaName", map.getKey());
			obj2.put("formulaExpression", map.getValue());
			arr.add(obj2);
		}
		obj.put("formulas", arr);
		return obj;
	}

	@SuppressWarnings("unchecked")
	public JSONObject addFormula(String formulaName , String formulaExpression) throws Exception {
		Operations o = new Operations();
		if (formulaExpression.contains("=")) {
			obj.put("status", "failure");
			obj.put("message", "give a valid expression");
		} 
		else if(formulaName.contains("sq(") || formulaName.contains("sqrt(") || formulaName.contains("pow(") || formulaName.contains("min(") || formulaName.contains("max(") || formulaName.contains("avg(")) {
			obj.put("status", "failure");
			obj.put("message", "It is a method's name");
		}
		else if (expressions.containsKey(formulaName)) {
			obj.put("status", "failure");
			obj.put("message", "formula already present");
		} else {
			o.addFormula(formulaName, formulaExpression);
			obj.put("status", "success");
			obj.put("message", "Added successfully");
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public JSONObject editFormula(String formulaName , String formulaExpression){
		Operations o = new Operations();
		if (formulaExpression.contains("=")) {
			obj.put("status", "failure");
			obj.put("message", "give a valid expression");
		} 
		else {
			try {
				o.updateFormula(formulaName, formulaExpression);
				obj.put("status", "success");
				obj.put("message", "updated successfully");
			} catch (Exception e) {
				obj.put("status", "failure");
				obj.put("message", "formula not found");
			}
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject deleteFormula(String formulaName){
		Operations o = new Operations();
		try {
			o.deleteFormula(formulaName);
			obj.put("status","success");
			obj.put("message", "deleted successfully");
		} catch (Exception e) {
			obj.put("status", "failure");
			obj.put("message", "formula not found");
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject check() throws Exception {
		formulas = new LinkedHashMap<String,Graphs>();
		Operations o = new Operations();
		expressions = o.getFormulas();
		for (Map.Entry<String, String> map : expressions.entrySet()) {
			createGraph(map.getKey(),map.getValue());
		}
		obj.put("result",Validate());
		return obj;
	}

}
