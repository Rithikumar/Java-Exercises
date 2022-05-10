package com.learn.ch7;

/**
 * <p>Returning objects</p>
 * @author rithi-zstch1028
 *
 */
class Test6 {
	int a;
	
	Test6(int i){
		a = i;
	}
	
	Test6 incrByTen() {
		Test6 temp = new Test6(a+10);
		return temp;
	}
}

/**
 * <p></p>
 * @author rithi-zstch1028
 *
 */
public class RetrunObject {
	public static void main(String[] args) {
		Test6 o = new Test6(4);
		
		Test6 ans = o.incrByTen();
		System.out.println(ans.a);
	}
}
