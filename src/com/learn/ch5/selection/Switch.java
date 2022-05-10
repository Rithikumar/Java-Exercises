package com.learn.ch5.selection;

/**
 * <p>
 * Experimentation on switch statements
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Switch {
	public static void main(String[] args) {
		boolean val = true;// boolean,float,double can't be used as expression in switch statement
		String val1 = "s";// String is accepted
		float val2 = 4.3f;
		switch (val1) {
		case "s":
			System.out.println("true");
			break;
		case "false":
			System.out.println("false");
			break;
		}
	}
}
