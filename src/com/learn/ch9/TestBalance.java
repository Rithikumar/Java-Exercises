package com.learn.ch9;

import com.learn.ch9.bank.Balance;
//if balance class is not public it throws :"the type com.learn.ch9.bank.Balance is not visible"
/**
 * <p>Driver class for class bank balance</p>
 * @author rithi-zstch1028
 *
 */
public class TestBalance {
	public static void main(String[] args) {
		Balance test = new Balance("Rithik",10);
		test.show();
	}

}
