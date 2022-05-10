package com.learn.ch5.jump;

/**
 * <p>
 * Usage of breaking labeled nested blocks
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class Goto {
	public static void main(String[] args) {

		first: {
			second: {
				third: {
					fourth: {
						System.out.println("Before the break");
						if (true)
							break third;
						System.out.println("This won't execute");
					}
					System.out.println("This won't execute");
				}
				System.out.println("This is after break,second block");
			}
			System.out.println("First block");
		}
	}
}
