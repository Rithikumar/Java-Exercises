package com.learn.ch5.Selection;

import java.util.Scanner;

/**
 * <p>
 * The program to find the season of the given month using the switch statments
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class SwitchSeason {
	public static void main(String[] args) {
		int month;
		Scanner scan = new Scanner(System.in);
		month = scan.nextInt();
		String season;
		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "Winter";
			break;
		case 3:
		case 4:
		case 5:
			season = "Spring";
			break;
		case 6:
		case 7:
		case 8:
			season = "Summer";
			break;
		case 9:
		case 10:
		case 11:
			season = "Autumn";
			break;
		default:
			season = "Bogus Month";
		}
		System.out.println("Season is " + season);
	}
}
