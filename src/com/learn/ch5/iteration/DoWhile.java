package com.learn.ch5.iteration;

import java.io.IOException;

/**
 * <p>
 * Basic implementation of do while loop and nested switch statements
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class DoWhile {
	public static void main(String[] args) throws IOException {
//        int n = 10;
//
//        do{
//            System.out.println("tick " + n);
//        }while(--n > 0);

		char choice = 0;

		do {
			System.out.println("Help on:");
			System.out.println("    1. if");
			System.out.println("    2. switch");
			System.out.println("    3. while");
			System.out.println("    4.do-while");
			System.out.println("    5.for\n");
			System.out.println("Choose one:");
			choice = (char) System.in.read();
		}
		// if the choice is greater than 5 the do-while loop is repeated again
		while (choice < '1' || choice > '5');

		System.out.println("\n");

		switch (choice) {
		case '1':
			System.out.println("The if:\n");
			System.out.println("if(condition) statement;");
			System.out.println("else statement");
			break;
		case '2':
			System.out.println("The switch:\n");
			System.out.println("switch(expression) {");
			System.out.println("    case constant:");
			System.out.println("        statement sequence");
			System.out.println("    break;");
			System.out.println("    // ...");
			System.out.println("}");
		case '3':
			System.out.println("The while:\n");
			System.out.println("while(condition) statement;");
			break;
		case '4':
			System.out.println("The do-while:\n");
			System.out.println("do {");
			System.out.println("    statement;");
			System.out.println("} while (condition);");
			break;
		case '5':
			System.out.println("The for:\n");
			System.out.println("for(init; condition; iteration)");
			System.out.println("    statement;");
			break;
		}
	}
}
