package com.learn.ch7;

/**
 * <p>Exploring command line arugments</p>
 * @author rithi-zstch1028
 *
 */
public class CommandLine {
	public static void main(String[] args) {
		System.out.println("HI");
		for(int i = 0 ; i< args.length ; i++) {
			System.out.println("args["+i+"]: "+args[i]);
		}
	}
}
