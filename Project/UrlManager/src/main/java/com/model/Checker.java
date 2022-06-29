package com.model;

import java.util.LinkedList;
import java.util.Map;

public class Checker {
	
	public String checkSampleUrl(String[] input,LinkedList<Map.Entry<String,Integer>> pathList,LinkedList<Map.Entry<String,Integer>> variableList) throws Exception {

		String result ="";
        //Checks the sample url with pattern url and checks whether all the paths are specified properly
        //throws exception if not matches
		int length = pathList.size()+variableList.size() ;
		if(input.length < length-1 || input.length > length) {
			throw new Exception("   Error: The Sample url doesn't match");
		}
        for(Map.Entry<String,Integer> m : pathList){
            if(!m.getKey().equals(input[m.getValue()].trim())){
            	
                throw new Exception("   Error: The Sample url doesn't match");
            }
        }
        result+=("The sample url matches.\n");
        //Checks and prints the values of variables
        //if variable is mentioned but not given value throws exception
        for (Map.Entry<String, Integer> m : variableList) {
            if (m.getValue() == input.length)
                result+=(m.getKey() + " - null\n");
            else {
                String variable = input[m.getValue()].trim();
                if(variable.equals("")){
                    throw new Exception("   Error: The "+m.getKey()+" is mandatory");
                }
                result+=(m.getKey() + " - " + variable+"\n");
            }
        }
        return result;
    }
}
