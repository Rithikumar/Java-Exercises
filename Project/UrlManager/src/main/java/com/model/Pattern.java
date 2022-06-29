package com.model;

import java.util.LinkedList;
import java.util.Map;

public class Pattern {
	
	private LinkedList<Map.Entry<String,Integer>> variableList;
	private LinkedList<Map.Entry<String,Integer>> pathList;
	private String samplePattern;
	
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
	
	public String getSamplePattern() {
		return samplePattern;
	}
	
	public void setSamplePattern(String samplePattern) {
		this.samplePattern = samplePattern;
	}
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Pattern [url=").append(samplePattern).append(", variableList=").append(variableList)
//		.append(",pathList=").append(pathList).append("]");
//		return builder.toString();
//	}
	
	@Override
	public String toString() {
		return samplePattern;
	}
}
