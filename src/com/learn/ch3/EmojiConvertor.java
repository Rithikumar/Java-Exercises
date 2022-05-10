package com.learn.ch3;

import java.util.Scanner;

/**
 * <p>
 * The Emoji Convertor converts the given String to a emoji
 * </p>
 * 
 * @author rithi-zstch1028
 */

public class EmojiConvertor {

	/**
	 * <p>
	 * The main class gets a input from the user and checks the values and converts
	 * some of the words into emojis
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// store emojis and their unicode in 2d array
		String[][] emojis = { { "smile", "\uD83D\uDE00" }, { "joy", "\uD83D\uDE02" }, { "cry", "\uD83D\uDE2D" },
				{ "love", "\uD83D\uDE0D" } };
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String line = scan.nextLine();// gets a string as an input
		for (String[] emoji : emojis) {// loops each emoji
			if (line.contains(emoji[0])) { // checks whether the the emojis are present for the words
				line = line.replace(emoji[0], emoji[1]);// replaces word with emoji
			}
		}
		System.out.println(line);
	}
}
