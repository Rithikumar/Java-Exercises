package com.learn.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * <p>
 * A sample program which validates the string condition and evaluates the
 * criteria and give a boolean value
 * <p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Parse {

	/**
	 * <p>
	 * This method creates an criteria object from a string, The string must be in
	 * the form of (key,operator,value), The brackets are optional.If the case is
	 * required to precedent perfect then giving brackets is a must. Also If you are
	 * trying to use "not" in brackets are must too.
	 * 
	 * The logic this program follows is that the string is iterated and each string
	 * inside the brackets are recursively calling itself and the criterion objects
	 * created are then combined by all the method "combiningCriterias"
	 * <p>
	 * 
	 * @param criteriaString    - The string which contains the condition
	 * @param allowedFilterCols - The key(variable name) which are allowed
	 * @param allowedOperators  - The operators which are allowed, null represents
	 *                          all operators
	 * @return - criteria, with the conditions
	 * @throws Exception - Exception with message is thrown for invalid cases
	 */
	public static Criteria loadFromString(String criteriaString, ArrayList<String> allowedFilterCols,
			ArrayList<Operator> allowedOperators) throws Exception {

		int noOfBrackets = 0;// Counts the brackets opened
		ArrayList<Object> criteriasPresent = new ArrayList<Object>();// Has the criteria and criterion objects
		ArrayList<String> conditions = new ArrayList<String>();// Has the condition like 'and', 'or'
		StringBuilder insideBrackets = new StringBuilder();// Adds each char inside brackets

		if (criteriaString.contains("(") || criteriaString.contains(")")) {
			// Loops each char
			for (char letter : criteriaString.toCharArray()) {
				if (letter == '(') {
					// Checks if it is the first bracket open , if not adds the inner bracket to the
					// 'insideBrackets' String
					if (noOfBrackets != 0) {
						insideBrackets.append(letter);
					}
					// Checks if the 'insideBrackets' is empty and adds it into conditions if there
					// is a criteria in criteriaPresent
					else if (!insideBrackets.toString().equals("") && criteriasPresent.size() != 0) {
						conditions.add(insideBrackets.toString());
						insideBrackets.setLength(0);
					}
					// Checks if the value is ! and adds the not to conditions
					else if (insideBrackets.toString().equals("!")) {
						conditions.add(insideBrackets.toString());
						insideBrackets.setLength(0);
					}
					// Increases the number of brackets each time it enters here
					noOfBrackets++;
				} else if (letter == ')') {
					noOfBrackets--;
					// Checks if there are any brackets opened right now and creates a criterion
					// object
					if (noOfBrackets == 0) {
						criteriasPresent
								.add(loadFromString(insideBrackets.toString(), allowedFilterCols, allowedOperators));
						insideBrackets.setLength(0);
					} else {
						insideBrackets.append(letter);
					}

				} else {
					insideBrackets.append(letter);
				}
				// Checks if there is value inside "inside brackets" which is not evaluated yet
				// and throws error
				if (criteriaString.indexOf(letter) == criteriaString.length() - 1
						&& !insideBrackets.toString().equals("")) {
					throw new Exception("Brackets not found on " + insideBrackets);
				}
			}
		}
		// If the value doesn't contain any brackets the string comes here
		else {
			// Throws exception here to notifies using of brackets for not
			if (criteriaString.contains("!")) {
				throw new Exception("Use brackets to specify nots");
			}
			// If contains 'and' in it
			else if (criteriaString.contains("and")) {
				String[] params = criteriaString.split("and");
				// loops the to create criterion object
				for (int i = 0; i < params.length; i++) {
					String criterionString = params[i];
					// Checks if there is any 'or' internally
					if (criterionString.contains("or")) {
						String[] params2 = criterionString.split("or");
						// if contains loops and creates criterion object
						for (int j = 0; j < params2.length; j++) {
							criteriasPresent.add(createCriterian(params2[j], allowedFilterCols, allowedOperators));
							if (j != params2.length - 1) {
								conditions.add("or");
							}
						}
					}
					// it does not contain any internally 'or'
					else {
						criteriasPresent.add(createCriterian(criterionString, allowedFilterCols, allowedOperators));
					}
					if (i != params.length - 1) {
						conditions.add("and");
					}
				}
			}
			// if contains 'or' in it
			else if (criteriaString.contains("or")) {
				String[] arr = criteriaString.split("or");
				for (int i = 0; i < arr.length; i++) {
					conditions.add("or");
					criteriasPresent.add(createCriterian(arr[i], allowedFilterCols, allowedOperators));
				}
			}
			// A single Criterion
			else {
				criteriasPresent.add(createCriterian(criteriaString, allowedFilterCols, allowedOperators));
			}
		}
		// Throws error if The string is not validated
		if (!insideBrackets.toString().equals("")) {
			throw new Exception("Invalid format");
		}

		return combiningCriterias(criteriasPresent, conditions);

	}

	/**
	 * <p>
	 * This method combines the criteria and criterion objects inside the arrayList
	 * <p>
	 * 
	 * @param criteriaPresent - Contains an array of criteria objects
	 * @param conditions      - Contains an array of conditions(and,or)
	 * @return - returns criteria after combining the array 'CriteriaPresent'
	 * @throws Exception - Exception with message is thrown for invalid cases
	 */
	private static Criteria combiningCriterias(ArrayList<Object> criteriaPresent, ArrayList<String> conditions)
			throws Exception {
		Criteria finalCriteria = new Criteria();
		// Loops the array of objects
		for (int i = 0; i < criteriaPresent.size(); i++) {
			Object criteriaObject = criteriaPresent.get(i);
			// checks if it is a instance of criteria
			if (criteriaObject instanceof Criteria) {
				if (i == 0) {
					// if first criteria has 'not' conditions
					if (!conditions.isEmpty() && conditions.get(i).equals("!")) {
						finalCriteria = finalCriteria.not((Criteria) criteriaObject);
						conditions.remove(0);
					} else {
						finalCriteria = finalCriteria.and((Criteria) criteriaObject);
					}
				} else {
					// condition 'or' is checked and combined
					if (conditions.get(i - 1).contains("or")) {
						if (conditions.get(i - 1).contains("!")) {
							finalCriteria = finalCriteria.notOr(criteriaObject);
						} else {
							finalCriteria = finalCriteria.or((Criteria) criteriaObject);
						}
					}
					// condition 'and' is checked and combined
					else if (conditions.get(i - 1).contains("and")) {
						if (conditions.get(i - 1).contains("!")) {
							finalCriteria = finalCriteria.notAnd(criteriaObject);
						} else {
							finalCriteria = finalCriteria.and((Criteria) criteriaObject);
						}
					}
					// Exception is thrown if the condition is neither 'and' nor 'or'
					else {
						throw new Exception("Joining type is invalid");
					}
				}
			}
			// checks if it is a instance of criterion
			else if (criteriaObject instanceof Criterian) {
				if (i == 0) {
					// if first criterion has 'not' condition
					if (!conditions.isEmpty() && conditions.get(i).equals("!")) {
						finalCriteria = finalCriteria.not((Criterian) criteriaObject);
						conditions.remove(0);
					} else {
						finalCriteria = finalCriteria.and((Criterian) criteriaObject);
					}
				} else {
					// Object is created for condition 'and'
					if (conditions.get(i - 1).contains("and")) {
						if (conditions.get(i - 1).contains("!")) {
							finalCriteria = finalCriteria.notAnd((Criterian) criteriaObject);
						} else {
							finalCriteria = finalCriteria.and((Criterian) criteriaObject);
						}
					}
					// Object is created for condition 'or'
					else if (conditions.get(i - 1).contains("or")) {
						if (conditions.get(i - 1).contains("!")) {
							finalCriteria = finalCriteria.notOr((Criterian) criteriaObject);
						} else {
							finalCriteria = finalCriteria.or((Criterian) criteriaObject);
						}
					}
					// Exception is thrown if neither 'and' nor 'or' is present
					else {
						throw new Exception("Joining type is invalid");
					}
				}
			}
		}
		return finalCriteria;
	}

	/**
	 * <p>
	 * The criterion is created here , after parsing and validating the operators
	 * and field names
	 * <p>
	 * 
	 * @param criterianString   - A string with a single criterion
	 * @param allowedFilterCols - Array containing the allowed field names
	 * @param allowedOperators  - Array containing the allowed operators, if null,
	 *                          all operators are included
	 * @return - returns a Criterion object after parsing the values
	 * @throws Exception - Exception message is thrown for invalid cases
	 */
	private static Criterian createCriterian(String criterianString, ArrayList<String> allowedFilterCols,
			ArrayList<Operator> allowedOperators) throws Exception {

		String[] params = criterianString.split(",");
		Criterian criterian = null;
		int opValue = Integer.parseInt(params[1]);

//		Working in progress
		try {
			if (params.length == 2) {
				if ((allowedOperators == null || allowedOperators.isEmpty()) && opValue == 5) {
					criterian = new Criterian(params[0], Operator.EXIST);
				} else if (allowedOperators.get(opValue) == Operator.EXIST) {
					criterian = new Criterian(params[0], Operator.EXIST);
				}
			}
		} catch (Exception e) {
			throw new Exception("The Operator is not allowed");
		}
		try {
			if (params.length == 4) {
				// validating key and value here
				checkVariable(params[0], allowedFilterCols);
				checkVariable(params[2], allowedFilterCols);
				checkVariable(params[3], allowedFilterCols);
				if ((allowedOperators == null || allowedOperators.isEmpty()) && opValue == 4) {
					criterian = new Criterian(params[0], Operator.BETWEEN, params[2], params[3]);
				} else if (allowedOperators.get(opValue) == Operator.BETWEEN) {
					criterian = new Criterian(params[0], Operator.BETWEEN, params[2], params[3]);
				}
			}
		} catch (Exception e) {
			throw new Exception("The Operator is not allowed");
		}
		if (params.length == 3) {
			// validating key and value here
			checkVariable(params[0], allowedFilterCols);

			// if null all operators are included
			if (allowedOperators == null || allowedOperators.isEmpty()) {
				switch (opValue) {
				case 0:
					criterian = new Criterian(params[0], Operator.EQUAL, params[2]);
					break;
				case 1:
					criterian = new Criterian(params[0], Operator.NOT_EQUAL, params[2]);
					break;
				case 2:
					criterian = new Criterian(params[0], Operator.GREATER_THAN, params[2]);
					break;
				case 3:
					criterian = new Criterian(params[0], Operator.LESSER_THAN, params[2]);
					break;
				default:
					throw new Exception("Operator is invalid in (" + params[0] + "," + opValue + "," + params[1] + ")");
				}
			}
			// Use operators present in the allowed operators
			else {
				// validating key and value here
				checkVariable(params[0], allowedFilterCols);
				if (allowedOperators.size() > opValue) {
					criterian = new Criterian(params[0], allowedOperators.get(opValue), params[2]);
				} else {
					throw new Exception("Operator is invalid in (" + params[0] + "," + opValue + "," + params[1] + ")");
				}
			}

		}
		// Exception is thrown if parameters are less or more
		else if(params.length != 4 && params.length !=2){
			throw new Exception("Parameters invalid in (" + criterianString + ")");
		}
		return criterian;
	}

	/**
	 * <p>
	 * This method check if the variable is present in the allowed names or not, if
	 * not found throws and error it also checks whether the quotes are used
	 * properly.
	 * <p>
	 * 
	 * @param toCheck           - the string contain the name of the fields
	 * @param allowedFilterCols
	 * @throws Exception
	 */
	private static void checkVariable(String toCheck, ArrayList<String> allowedFilterCols) throws Exception {
		toCheck = toCheck.trim();
		// checks if contains 'tocheck' contains double quotes
		if (toCheck.contains("\"")) {
			// if the double quote is not close or not opened throws an exception
			if (!(toCheck.charAt(0) == '"' && toCheck.charAt(toCheck.length() - 1) == '"')) {
				throw new Exception("Improper value assigning in " + toCheck);
			}
		} else {
			boolean isPresent = false;
			// loops and checks if the field is
			for (int i = 0; i < allowedFilterCols.size(); i++) {
				if (allowedFilterCols.get(i).equals(toCheck)) {
					isPresent = true;
				}
			}
			if (!isPresent) {
				throw new Exception("Variable name \"" + toCheck + "\" is not in the allowed columns");
			}
		}
	}

	public static void main(String[] args) {

		// Fields which can be present
		ArrayList<String> allowedFilterCols = new ArrayList<String>();
		allowedFilterCols.add("field1");
		allowedFilterCols.add("field2");
		allowedFilterCols.add("field3");
		allowedFilterCols.add("field4");
		allowedFilterCols.add("phone1");
		allowedFilterCols.add("age");
		allowedFilterCols.add("gender");

		// Operators which are allowed
		ArrayList<Operator> allowedOperators = new ArrayList<Operator>();
//		allowedOperators.add(Operator.EQUAL);
//		allowedOperators.add(Operator.NOT_EQUAL);

		System.out.print("Enter string: ");
		String in = new Scanner(System.in).nextLine();

		// Map containing the values of fields
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("field1", "4");
		map.put("field2", "3");
		map.put("field3", "2");
		map.put("field4", "1");
		map.put("phone1", "9876543210");
		map.put("age", "3");
		map.put("gender", "M");
		try {
			// .out.println(((Criteria) loadFromString(in)).toString());
			Criteria result = loadFromString(in, allowedFilterCols, allowedOperators);
			System.out.println(result.getCriteriaString());
			System.out.println(Criteria.evaluate(result, map));

		} catch (Exception e) {
			e.printStackTrace();
//			int[] numbers = {1,2,3,4,5};
//			int i = numbers[3];
//			
//			ArrayList[] number 

			// case " EXISTS ":
			// return
		}
	}
}