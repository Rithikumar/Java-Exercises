package crieteriaOld;
//package crieteria;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Parse2 {
//	
//	public static Crieteria getSeparate(String res) {
//
//		Crieteria c = null;
//		if (res.contains("and")) {
//			res = res.substring(res.indexOf("and") + 3);
//			String[] arr = res.split(",");
//
//			if (arr.length == 3) {
//				c = new Crieteria(arr[0], arr[1], arr[2]);
//				// System.out.println(c.query);
//			} else {
//				Arrays.toString(arr);
//				System.out.println("Invalid arugments");
//			}
//		} else if (res.contains("or")) {
//			res = res.substring(res.indexOf("or") + 2);
//			String[] arr = res.split(",");
//
//			if (arr.length == 3) {
//				c = new Crieteria(arr[0], arr[1], arr[2]);
//				// System.out.println(c.query);
//			} else {
//				System.out.println("Invalid arugments");
//			}
//		} else {
//			String[] arr = res.split(",");
//
//			if (arr.length == 3) {
//				c = new Crieteria(arr[0], arr[1], arr[2]);
//				// System.out.println(c.query);
//			} else {
//				Arrays.toString(arr);
//				System.out.println("Invalid arugments");
//			}
//		}
//
//		return c;
//	}
//
//	public static Crieteria getSeparate(String res, Crieteria c) {
//		if (res.contains("and")) {
//			res = res.substring(res.indexOf("and") + 3);
//			String[] arr = res.split(",");
//
//			if (arr.length == 3) {
//				c.and(arr[0], arr[1], arr[2]);
//				// System.out.println(c.query);
//			} else {
//				// Arrays.toString(arr);
//				System.out.println("Invalid arugments");
//			}
//		} else {
//			res = res.substring(res.indexOf("or") + 2);
//			String[] arr = res.split(",");
//
//			if (arr.length == 3) {
//				c.or(arr[0], arr[1], arr[2]);
//				// System.out.println(c.query);
//			} else {
//				Arrays.toString(arr);
//				System.out.println("Invalid arugments");
//			}
//		}
//		return c;
//	}
//
//	public static void does(String value) {
//		String res = "";
//		Stack<Character> s = new Stack<Character>();
//		Stack<String> op = new Stack<String>();
//		Stack<String> query = new Stack<String>();
//		for (char a : value.toCharArray()) {
//			if (a == '(') {
//				s.add(a);
//			} else if (a == ')') {
//				if (res != "") {
//					query.add(res);
//				}
//				s.add(a);
//				res = "";
//			} else {
//				res += a;
//				if (res.contains("and") || res.contains("or")) {
//					op.add(res);
//					res = "";
//				}
//			}
//		}
//		segregate(s,op,query);
//	
//	}
//	
//	public static void segregate(Stack pres , Stack op , Stack query) {
//		Stack<Crieteria> cr = new Stack<Crieteria>();
//		  Iterator itr1 = query.iterator();
//		  Iterator itr = pres.iterator();
//	      int count = 0;
//	      
//	      while(itr1.hasNext()) {
//	    	  Crieteria c = getSeparate(itr1.next().toString());
//	    	  cr.push(c);
//	      }
//	      
//	      while(!pres.isEmpty()) {
//	    	  
//	      }
//	      
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String value = sc.nextLine();
//		does(value);
//	}
//}
