package crieteria;

import java.util.Scanner;
import java.util.Stack;

public class Parse4 {

	static Stack<String> s = new Stack<>();

	public static Crieteria recur(String in) {
		String res = "";
		int count = 0;
		Stack<Crieteria> st = new Stack<Crieteria>();
		Stack<String> conditions = new Stack<String>();

		if (in.contains("(") && in.contains(")")) {
			for (char a : in.toCharArray()) {
				if (a == '(') {
					if (count != 0) {
						res += a;
					} else if (res != "" && st.size() != 0) {
						conditions.push(res);
						res = "";
					}

					count++;
				} else if (a == ')') {
					count--;
					if (count == 0) {
						st.push(recur(res));
						res = "";
					} else {
						res += a;
					}

				} else {
					res += a;
				}
			}
		} else {
			String[] arr = in.split(",");
			Crieteria c = new Crieteria(arr[0], arr[1], arr[2]);
			return c;
		}
		if (conditions.size() == 1) {
			if (conditions.peek().contains("and")) {
			Crieteria c1 = st.pop();
			Crieteria c2 = st.pop();
			conditions.pop();
			c1.andS(c2);
			st.push(c1);
			}
			else {
				Crieteria c1 = st.pop();
				Crieteria c2 = st.pop();
				conditions.pop();
				c1.orS(c2);
				st.push(c1);
			}
			
		}
		while (!conditions.isEmpty()) {
			if (conditions.peek().contains("and")) {
				Crieteria c1 = st.pop();
				Crieteria c2 = st.pop();
				conditions.pop();
				c1.and(c2);
				st.push(c1);
			} else {
				Crieteria c1 = st.pop();
				Crieteria c2 = st.pop();
				conditions.pop();
				c1.or(c2);
				st.push(c1);
			}
		}

		return st.pop();
	}

	public static void main(String[] args) {
		String a = new Scanner(System.in).nextLine();
		System.out.println(recur(a).query);
	}
}
