package com.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class VariableGetter {
	
	private LinkedList<Map.Entry<String, Integer>> variableList;
    private LinkedList<Map.Entry<String, Integer>> pathList;
	
	public void setPathAndVariables(String[] urlArray) throws Exception {

        LinkedHashMap<String, Integer> params = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> urlPaths = new LinkedHashMap<>();

        for (int i = 0; i < urlArray.length; i++) {
            String param = urlArray[i];

            //checks whether the variable is correctly mention if correctly mentioned stores it
            //also separates paths and variables , stores with index.
            if (!param.contains("{") && param.contains("}")) {
                throw new Exception("   Error: The " + param.substring(0, param.length() - 1) + " is not opened with {");
            } else if (param.contains("{")) {
                if (param.contains("}") && !param.substring(1).equals(""))
                    params.put(param.substring(1, param.length() - 1), i);
                else
                    throw new Exception("   Error: The " + param.substring(1) + " is not closed with }.");
            } else {
                urlPaths.put(param.trim(), i);
            }
        }

        variableList = new LinkedList<>(params.entrySet());
        pathList = new LinkedList<>(urlPaths.entrySet());
        System.out.println(variableList);
        System.out.println(pathList);
    }
	
	public void setUrl(String url) throws Exception {
		if (url.contains("\\") || url.contains("///") || url.contains("{}"))
            throw new Exception("   Error: Give a valid url");
        String[] urlArray = url.split("/");
        setPathAndVariables(urlArray);
	}

	public LinkedList<Map.Entry<String, Integer>> getVariableList() {
		return variableList;
	}

	public void setVariableList(LinkedList<Map.Entry<String, Integer>> variableList) {
		this.variableList = variableList;
	}

	public LinkedList<Map.Entry<String, Integer>> getPathList() {
		return pathList;
	}

	public void setPathList(LinkedList<Map.Entry<String, Integer>> pathList) {
		this.pathList = pathList;
	}
}
