package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.model.Checker;
import com.model.Pattern;
import com.model.VariableGetter;
import com.opensymphony.xwork2.ActionSupport;

public class Control extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String url;
	private static ArrayList<Pattern> patterns = new ArrayList<>();
	private JSONObject obj = new JSONObject();
	private String sampleUrl;
	
	static {
		demoPatterns("meet/{meet-id}/location/{location-id}");
		demoPatterns("meet/location/{location-id}");
		demoPatterns("meet/{meet-id}/");
		demoPatterns("meet/location/spot");
		demoPatterns("meet/{token}/open");
		demoPatterns("meet/user/{user-id}");
		demoPatterns("meet/12");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getSampleUrl() {
		return sampleUrl;
	}

	public void setSampleUrl(String sampleUrl) {
		this.sampleUrl = sampleUrl;
	}
	
	@SuppressWarnings("unchecked")
	public void addPattern() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			checker(url);
			Pattern pt = new Pattern();
			System.out.println(url);
			VariableGetter vg = new VariableGetter();
			pt.setSamplePattern(url);
			vg.setUrl(url);
			pt.setPathList(vg.getPathList());
			pt.setVariableList(vg.getVariableList());
			patterns.add(pt);
			obj.put("status", "success");
		}catch(Exception e) {
			obj.put("status","failure");
			obj.put("message", e.getMessage());
		}
		finally {
			PrintWriter out = response.getWriter();
			out.println(obj.toJSONString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void getPatterns() throws IOException {
		JSONArray arr = new JSONArray();
		HttpServletResponse response = ServletActionContext.getResponse();
		for(Pattern pt:patterns) {
			arr.add(pt.toString());
		}
		PrintWriter out = response.getWriter();
		out.println(arr);
	}
	
	@SuppressWarnings("unchecked")
	public void check() throws IOException{
		JSONArray arr = new JSONArray();
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.print(sampleUrl);
		Checker ck = new Checker();
		for(Pattern pt:patterns) {
			JSONObject obj = new JSONObject();
			System.out.println(pt.getPathList());
			System.out.println(pt.getVariableList());
			try {
				String res = ck.checkSampleUrl(sampleUrl.split("/"), pt.getPathList(), pt.getVariableList());
				System.out.println("no error");
				obj.put("value",res);
				obj.put("matches","yes");
				arr.add(obj);
			} catch (Exception e) {
				System.out.println("error");
				obj.put("matches", "no");
				obj.put("message",e.getMessage());
				arr.add(obj);
			}
		}
		PrintWriter out = response.getWriter();
		out.println(arr);
	}
	
	public static void demoPatterns(String url){
		Pattern pt = new Pattern();
		VariableGetter vg = new VariableGetter();
		pt.setSamplePattern(url);
		try {
			vg.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pt.setPathList(vg.getPathList());
		pt.setVariableList(vg.getVariableList());
		patterns.add(pt);
	}
	
	public void checker(String check) throws Exception {
		for(Pattern pt:patterns) {
			if(check.equals(pt.getSamplePattern())){
				throw new Exception("pattern already exists.");
			}
		}
	}
}
