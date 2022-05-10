import java.math.BigInteger;
import java.util.Scanner;

/**
 * <p>
 * Finds the value of the number using recursion
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Factorial {

	/**
	 * This method is used to find the factorial of the number. This method uses
	 * recursion to find the result. The recursion stops when number is 0;
	 * 
	 * @param num ,This is the number for whom factorial must be obtained
	 * @return the factorial of the number
	 */
	static BigInteger one = new BigInteger("1");

	public static BigInteger calc(BigInteger num) {
//		System.gc();
		if (num.compareTo(new BigInteger("90000")) == 0) {
			System.out.println();
		}
		if (num.compareTo(new BigInteger("0")) == 0)
			return one;
		return num.multiply(calc(num.subtract(one)));
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean continues;
		continues = true;
		String res = null;
		// Loops till the user specifics to stop
		while (continues) {
			System.out.println("Input: ");
			boolean inValid = true;
			BigInteger b = null;
			// Loops till the user assigns a value within the required range
			while (inValid) {
				System.out.print("Enter the number to calculate factorial: ");
				b = scan.nextBigInteger();
				// b.compareTo returns
				// 1 if b is greater than the argument
				// 0 if b is equal to the argument
				// -1 if b is lesser than the argument
				if (b.compareTo(new BigInteger("0")) == -1) {
					System.out.println("Error: The number must be greater than 0");
				} else
					inValid = false;
			}
			System.out.println("Output: " + calc(b));
			boolean continueValid = true;
			// Loops till the user gives a valid input(yes or no)
			while (continueValid) {
				System.out.print("Do you want to continue(Y/N) ? ");
				res = scan.next().toLowerCase();
				if (res.equals("n") || res.equals("no")) {
					continueValid = false;
					continues = false;
				} else if (!res.equals("y") && !res.equals("yes")) {
					System.out.println("Error: The only valid input is Y(yes) or N(no)");
				} else {
					continueValid = false;
				}
			}
		}

	}
}
