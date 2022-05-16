package com.learn.ch5.selection;

import java.util.Scanner;

/**
 * <p>
 * Experimentation on usage of different control statements
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Test1 {
	public static void main(String[] args) {
		// continuous 'if' can be used if more than one condition needs to be present
		int age;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		age = scan.nextInt();
		if (age < 2)
			System.out.println("You are a baby");
		if (age < 39)
			System.out.println("You are a young adult");
		if (age < 59)
			System.out.println("You are a middle aged adult");
		if (age < 99) {System.out.println("You are a old adult");}
		// if executed will print all the statements , we can solve this in 3 ways
		// normal if with multiple conditions
		System.out.println("\nMultiple conditions\n");
		if (age > 0 && age < 3)
			System.out.println("You are a baby");
		if (age > 3 && age < 39)
			System.out.println("You are a young adult");
		if (age > 39 && age < 59)
			System.out.println("You are a middle-aged adult");
		if (age > 59 && age < 99)
			System.out.println("You are a old adult");
		// nested if
		System.out.println("\nNested If \n");
		if (age > 3) {
			if (age > 39) {
				if (age > 59) {
					System.out.println("You are a old adult");
				} else
					System.out.println("You are a middle aged adult");
			} else
				System.out.println("You are a young adult");
		} else
			System.out.println("You are a baby");
		// if else-if
		System.out.println("\nElse if\n");
		if (age < 3)
			System.out.println("You are a baby");
		else if (age < 39)
			System.out.println("You are a young adult");
		else if (age < 59)
			System.out.println("You are a middle aged adult");
		else if (age < 99)
			System.out.println("You are a old adult");
	}
}
