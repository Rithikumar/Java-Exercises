package com.learn.ch5.Selection;

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
		month = scan.nextInt();
		if (month == 12 || month < 3)
			season = "Winter";
		else if (month < 6)
			season = "Spring";
		else if (month < 9)
			season = "Summer";
		else if (month < 12)
			season = "Autumn";
		else
			season = "Bogus Month";
		System.out.println("The season you chose is " + season);
	}
}
