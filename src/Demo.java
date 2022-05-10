/**
 * Checking if working
 * @author rithi-zstch1028
 *
 */
public class Demo {
	public static void main(String[] args) {
		boolean condition1 = false;
		boolean condition2 = false;
		boolean b = false ^ true;
		if(condition1 ^ condition2) {
			System.out.println("in");
		}
		else if(condition1 && condition2) {
			System.out.println("Both true");
		}
		else 
			System.out.println("both false");
	}
}
