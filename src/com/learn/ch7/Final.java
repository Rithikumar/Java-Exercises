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
	final int FILE_OPEN;
	final int FILE_SAVE = 3;
	
	Final(){
		this.FILE_OPEN = 0;
	}

	final static int give(final int num) {
		//num = 5;
		return num;
	}

	public static void main(String[] args) {
		// FILE_NEW = 12; is not editable
		System.out.println(give(3));
		
	}

}
