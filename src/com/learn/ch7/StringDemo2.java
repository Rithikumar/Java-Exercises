package com.learn.ch7;

/**
 * <p>
 * More on Strings part 2
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str1 = "First String";
		String str2 = "Second String";
		String str3 = str1;

		System.out.println(str1.length());
		System.out.println(str1.charAt(3));

		if (str1.equals(str2))
			System.out.println("str1 == str2");
		else
			System.out.println("str1 != str2");

		if (str1.equals(str3))
			System.out.println("str1 == str3");
		else
			System.out.println("str1 != str3");
	}
}
