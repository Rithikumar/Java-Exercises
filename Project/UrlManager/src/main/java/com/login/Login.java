package com.login;

public class Login{
	
	private String username;
	private String password;
	private String error;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String execute() {
		System.out.println("in");
		if(username.equals("Rithik") && password.equals("1234")) 
			return "success";
		setError("User not found");
		return "failure";
	}

}
