package crieteriaOld;

import java.util.ArrayList;

public class Norm {
		ArrayList<Object> criTek = new ArrayList<Object>();
		ArrayList<String> condition = new ArrayList<String>();
		
		Norm(String name , String type , String value){
			type = changeToCondition(type);
			if(type != null) {
				ArrayList<Object> arr = new ArrayList<Object>();
				arr.add(name);
				arr.add(type);
				arr.add(value);
				criTek.add(arr);
			}
		}
		
		public static String changeToCondition(String type) {
			switch(type) {
				case "1":
					return " = ";
				case "2":
					return " > ";
				case "3":
					return " < ";
				case "4":
					return " != ";
				default:
					return null;
			}
		}
		
		public void and(String name , String type , String value) {
			ArrayList<Object> arr = new ArrayList<Object>();
			arr.add(name);
			arr.add(type);
			arr.add(value);
			criTek.add(arr);
			condition.add("and");
		}
		
		public void and(Norm n) {
			criTek.add(n);
			condition.add("and");
		}
		
		public void or(String name , String type , String value) {
			ArrayList<Object> arr = new ArrayList<Object>();
			arr.add(name);
			arr.add(type);
			arr.add(value);
			criTek.add(arr);
			condition.add("or");
		}
		
		public void or(Norm n) {
			criTek.add(n);
			condition.add("or");
		}
}
