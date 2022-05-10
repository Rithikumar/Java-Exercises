/**
 * <p>
 * This class explores the problems of the boolean operators
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Demo {
	public static void main(String[] args) {

		/*
		 * This program prints in if any one condition is true , prints both true when
		 * both conditions are true prints both false when both conditions are false
		 * 
		 */
		boolean condition1 = false;
		boolean condition2 = false;

		// using xor
		if (condition1 ^ condition2) {
			System.out.println("in");
		}
		// using and
		else if (condition1 && condition2) {
			System.out.println("Both true");
		} else
			System.out.println("both false");
	}
}
