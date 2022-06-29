package com.formulas;

import java.util.Scanner;

public class Methods {

	public static float sq(float a) {
		return a * a;
	}

	public static float sqrt(float a) {
		return (float) Math.sqrt(a);
	}

	public static float pow(float a, float b) {
		return (float) Math.pow(a, b);
	}

	public static float average(String[] arr) throws Exception {
		int count = 0;
		float res = 0;
		for (String a : arr) {
			res += Float.parseFloat(a);
			count++;
		}
		return res / count;
	}

	public static float min(String[] arr) throws Exception {
		float min = 0;
		for (int i = 0; i < arr.length; i++) {
			float num = Float.parseFloat(arr[i]);
			if (i == 0)
				min = num;
			else if (num < min)
				min = num;
		}
		return min;
	}

	public static float max(String[] arr) throws Exception {
		float max = 0;
		for (int i = 0; i < arr.length; i++) {
			float num = Float.parseFloat(arr[i]);
			if (i == 0)
				max = num;
			else if (num > max)
				max = num;
		}
		return max;
	}

	public static float executes(String method) throws Exception {
		String parameter = method.substring(method.indexOf('(') + 1, method.indexOf(')'));
		if (method.contains("sq(")) {
			return sq(Float.parseFloat(parameter));
		} else if (method.contains("sqrt(")) {
			return sqrt(Float.parseFloat(parameter));
		} else if (method.contains("pow(")) {
			String[] arr = parameter.split(",");

			if (arr.length != 2)
				throw new Exception("Parameters are invalid");
			float a1 = Float.parseFloat(arr[0]);
			float a2 = Float.parseFloat(arr[1]);
			return pow(a1, a2);

		} else if (method.contains("avg(")) {
			String[] arr = parameter.split(",");

			return average(arr);
		} else if (method.contains("min(")) {
			String[] arr = parameter.split(",");

			return min(arr);

		} else if (method.contains("max(")) {
			String[] arr = parameter.split(",");

			return max(arr);

		} else {
			throw new Exception("Method not found");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("method : ");
		String method = scan.nextLine();
		try {
			System.out.println(executes(method));
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
