package com.learn.ch6.statics;

public class Import {
	
	public static void main(String[] args) {
		//The import word just specifics the class name it must call
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// Import just saves us time too not type entire package.class 
		// Unused imports have no performance impact at runtime
		String name = sc.nextLine();
		System.out.println(name);
	
	}

}
