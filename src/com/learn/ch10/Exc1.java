package com.learn.ch10;

/**
 * <p>
 * Experimenting uncaught exceptions
 * <p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Exc1 {

	static void subroutine() {
		int a = 10 / 0;// logically wrong throws exception
	}

	public static void main(String[] args) {
		subroutine();// calls method subroutine

		/* Exception that is thrown
		 * Exception in thread "main" java.lang.ArithmeticException: / by zero at
		 * com.learn.ch10.Exc1.subroutine(Exc1.java:11) at
		 * com.learn.ch10.Exc1.main(Exc1.java:15)
		 */
	}
}
