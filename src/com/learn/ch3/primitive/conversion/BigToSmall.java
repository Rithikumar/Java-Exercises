package com.learn.ch3.primitive.conversion;

/**
 * <p>
 * Class in which type casting explored more
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class BigToSmall {

	public static void main(String[] args) {
		byte a = 127;// no error
		// byte b = 128;// error
		byte c = (byte) (a + 2);// type casting to byte gives -127
		// starts from reverse
		// byte d = a + c;// even though a and c are both bytes'
		// java promotes a and c to int while evaluating
		// float g = 44.4;
		float e = (float) 44.4;// default the floating values are
		// taken in double to store it in the float we must type cast it or put f at
		// last
		float f = 444.4444444444444444444f;// 32 bits , 8 exponent , 1 point ,23 number
		double n = 3.3;// does not require specifying
		double o = 3.3D;// does not matter even specified
		int h = 'x';// the ascii value of char is taken
		char i = 33;// the value present in specified ascii table is taken
		long j = a;// promotion takes place
		long k = (int) a;// even type casting won't affect promotion

		// int l = true;//does not allow boolean
		// boolean m = 1;//does not allow
	}
}
