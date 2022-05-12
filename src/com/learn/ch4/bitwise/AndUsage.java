package com.learn.ch4.bitwise;

/**
 * <p>
 * A simple program in which each time a random number is given using some
 * expression, program is also useful to understand and usage
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class AndUsage {

	private static String result = null;

	/**
	 * <p>
	 * A method to stall sometime
	 * </p>
	 * 
	 * @return always 1
	 */
	public static int slow() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * <p>
	 * A method to assign value to result
	 * </p>
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 */
	public static boolean expression(int num1, int num2, int num3) {
		if(num1 == num2) {
			result = num1 + "+" + num2 + "+" + num3;
			return true;
		}
		return false;
	}

	/**
	 * <p>The logic used here is that each time the method is invoked it increases the number of
	 * time it runs,(it skips at 4th time) </p>
	 * @param args
	 */
	public static void main(String[] args) {
		//int b = 14 && 2;// Error
		int numOfTimes,num1,num2,num3;//variables declared 
		numOfTimes = 0;
		num1 = num2 = num3 =  15;
		num1 = 3;
		//for bitwise and
		if(++numOfTimes == 4 & ++num1 == 16 & ++num2 == 16 & ++num3 == 16) {
			//here all the variable are incremented 
			System.out.println("all incremented "+numOfTimes+""+num1+""+num2+""+num3);			
		}
		// even if false all variables are incremented
		//We might need to increment the numbers only after first is valid not before
		else if(++numOfTimes == 4 & slow() == 1) {
			//here our priority is numOfTimes as we will skip this if it equals four
			//but as both the side checked some time is wasted here
			System.out.println("Time is wasted here");
		}
		else if (expression(num1,num2,num3) & result.contains("-")) {
			System.out.println("Error");
		}
		//for logical and
		if(++numOfTimes == 4 && ++num1 == 16 && ++num2 == 16 && ++num3 == 16) {
			//here only numOfTimes incremented
			System.out.println("all incremented "+numOfTimes+""+num1+""+num2+""+num3);
		}
		//if false only numOfTimes is incremented
		else if (++numOfTimes == 4 && slow() ==1) {
			//here slow() method isn't called if first condition is false
			System.out.println("Time is not wasted here");
		}
		//no error found here
		else if (expression(num1,num2,num3) && result.contains("-")) {
			System.out.println(true);
		}
	}

}
