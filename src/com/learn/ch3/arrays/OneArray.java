package com.learn.ch3.arrays;

/**
 * <p>
 * The class prints the months and the no of days present in the month using an
 * array
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class OneArray {

	/**
	 * Here the values in the array are stored in two different approaches
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] month_days;
		// First approach
		String[] month_names = { "January", "February", "march", "april", "may", "june", "july", "august", "september",
				"october", "november", "december" };
		// Second approach
		month_days = new int[12];
		month_days[0] = 31;
		month_days[1] = 28;
		month_days[2] = 31;
		month_days[3] = 30;
		month_days[4] = 31;
		month_days[5] = 30;
		month_days[6] = 31;
		month_days[7] = 31;
		month_days[8] = 30;
		month_days[9] = 31;
		month_days[10] = 30;
		month_days[11] = 31;

		System.out.println("April has " + month_days[3] + " days.");
		// printing starts here
		for (int i = 0; i < month_days.length; i++) {
			System.out.println(month_names[i] + " has " + month_days[i] + " days.");
		}
	}
}
