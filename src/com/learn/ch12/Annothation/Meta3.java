package com.learn.ch12.Annothation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
	String str();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}

@What(description = "An annotation test class")
@MyAnno2(str = "Meta3", val = 99)
public class Meta3 {
	
	@What(description = "an annotation test method")
	@MyAnno2 (str = "Testing", val = 100)
	public static void myMeth() {
		Meta3 ob = new Meta3();
		
		try {
			Annotation[] annos = ob.getClass().getAnnotations();
			
			System.out.println("All annotation for Meta2:");
			for(Annotation a : annos)
				System.out.println(a);
			
			System.out.println();
			
			Method m = ob.getClass().getMethod("myMeth");
			annos = m.getAnnotations();
			
			System.out.println("All annotations for myMeth:");
			for(Annotation a : annos)
				System.out.println(a);
		}
		catch (Exception e) {
			System.out.println("Method not found");
		}
	}
	
	public static void main(String[] args) {
		myMeth();
	}

}
