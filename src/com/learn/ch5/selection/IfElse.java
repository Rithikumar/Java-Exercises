package com.learn.ch5.selection;

import java.util.Scanner;

/**
 * <p>
 * A small program in which season is given according to the season using
 * if-else-if
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class IfElse {
	public static void main(String[] args) {
		int month;
		String season;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		month = scan.nextInt();
		if(month < 0 || month > 12)
			season = "Bogus Month";
		else if (month == 12 || month < 3)
			season = "Winter";
		else if (month < 6)
			season = "Spring";
		else if (month < 9)
			season = "Summer";
		else
			season = "Autumn";
		System.out.println("The season you chose is " + season);
	}
}
