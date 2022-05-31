package com.learn.ch7;

/**
 * <p>
 * final examples
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Final {
	final int FILE_NEW = 1;// full capitals
	final int FILE_OPEN = 2;
	final int FILE_SAVE = 3;

	final static int give() {
		return 4;
	}

	public static void main(String[] args) {
		// FILE_NEW = 12; is not editable
		System.out.println(give());
	}

}

