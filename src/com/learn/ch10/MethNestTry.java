package com.learn.ch10;

/**
 * <p>Try statements can be implicitly nested via calls to methods.<p>
 * @author rithi-zstch1028
 *
 */
public class MethNestTry {
	static void nestTry(int a) {
		try {
			//nested try block
			/* if one command-line args is used,
			 * then a divide-by-zero exception
			 * will be generated by the following */
			if(a == 1) {a = a/(a-a);}
			/*if two command line args are used,
			 * then generate an out of bound exception*/
			if(a==2) {
				int[] c = {1};
				c[42] = 99; //generate an out of bounds exception
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out-of-bounds: " + e);
		}
	}
	
	public static void main(String[] args) {
		try {
			int a = args.length;
			
			/*if no command-line args are present ,
			 * the following statement will generate
			 * a divide by zero exception.
			 */
			
			int b = 42/a;
			System.out.println("a = " + a);
			
			nestTry(a);
		}
		catch(ArithmeticException e) {
			System.out.println("Divide by 0: " + e);
		}
	}
}
