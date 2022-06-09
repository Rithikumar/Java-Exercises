package crieteriaOld;

public class Crieteria {
	String query = "";

	Crieteria(String colName, String type, String value) {
		switch (type) {
		case "1":
			query = "select * from table where " + colName + " = " + value;
			break;
		case "2":
			query = "select * from table where " + colName + " > " + value;
			break;
		case "3":
			query = "select * from table where " + colName + " < " + value;
			break;
		case "4":
			query = "select * from table where " + colName + " like " + value;
			break;
		}
	}

	void andS(Crieteria a) {
		String[] arr = query.split("where");
		String s = arr[1];
		String s1 = a.query.split("where")[1];
		if (s1.contains("and") || s1.contains("or")) {
			query = arr[0] + " where (" + s1 + ") and (" + s + ")";
		} else if (s.contains("and") || s.contains("or")) { 
			query = arr[0] + " where (" + s1 + ") and (" + s + ")";
		}
		else {
			query = arr[0] + "where " + s1 + " and " + s;
		}
	}

	void and(Crieteria c) {
		// continues
		String[] arr = query.split("where");
		String s = arr[1];
		String s1 = c.query.split("where")[1];
		query = arr[0] + " where " + s1 + " and " + s ;
		}

	void orS(Crieteria a) { 
		String[] arr = query.split("where");
		String s = arr[1];
		String s1 = a.query.split("where")[1];
		if (s1.contains("or") || s1.contains("and")) {
			query = arr[0] + " where (" + s1 + ") or (" + s + ")";
		} else if (s.contains("and") || s.contains("or")) { 
			query = arr[0] + " where (" + s1 + ") or (" + s + ")";
		}else {
			query = arr[0] + "where " + s1 + " or " + s;
		}
	}

	void or(Crieteria c) {
		String[] arr = query.split("where");
		String s = arr[1];
		String s1 = c.query.split("where")[1];
		query = arr[0] + " where " + s1 + " or " + s ;
		
	}
}
