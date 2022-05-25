package com.learn.ch9.interfaces;

interface CallBack {
	int n = 0;
	static void callBack(int a) {
		System.out.println("hi");
	}
	int sum(int a,int b);
}
