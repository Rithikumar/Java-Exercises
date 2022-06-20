package com.learn.ch12.Annothation;

import java.lang.annotation.*;
import java.lang.reflect.*;

// An annotation type declaration that includes defaults.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno4 {
	String str() default "Testing";

	int val() default 9000;
}

public class Meta4 {

	// Annotate a method using the default values.
	@MyAnno4()
	public static void myMeth() {
		Meta4 ob = new Meta4();
		// Obtain the annotation for this method
		// and display the values of the members.
		try {
			Class c = ob.getClass();
			Method m = c.getMethod("myMeth");

			MyAnno4 anno = m.getAnnotation(MyAnno4.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException exc) {
			System.out.println("Method Not Found.");
		}
	}

	public static void main(String args[]) {
		myMeth();
	}

}
