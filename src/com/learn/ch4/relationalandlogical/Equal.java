package com.learn.ch4.relationalandlogical;

/**
 * <p>
 * Different approaches on usage of Equals operator
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Equal {

	public static void main(String[] args) {
		boolean a = "win" == "win";
		boolean b = 2 == 2;
		String a1 = new String("name");
		String a2 = new String("name");
		Integer b1 = new Integer(3);// for new int is npt auto boxed thus resembling different number
		Integer b2 = new Integer(3);
		// int a4 = (int)true;
		boolean c = a1 == a2;
		boolean d = b1 == b2;
		long c1 = 55;
		int c2 = 55;
		boolean e = c1 == c2;
		boolean h = true == 5 < 4;
		boolean i = true == false;
		System.out.println(a + " " + b + " " + c + " " + d + " " + e);
	}
}
