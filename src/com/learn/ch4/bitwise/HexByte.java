package com.learn.ch4.bitwise;

/**
 * <p>
 * Class in which the a hexcode is generated using bitwise operators
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
public class HexByte {
	public static void main(String[] args) {
		char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		byte b = (byte) 0xf1;// 11110001 >> 4 = 11111111 &=
		// & 00001111 & 00001111
		// 00000001 00001111
		System.out.println("b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
	}
}
