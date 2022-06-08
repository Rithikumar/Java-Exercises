package com.learn.ch11.creation;

class CallMe{
	void call (String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
	
	int add(int num1 , int num2) {
		return num1+num2;
	}
}

class Caller implements Runnable {
	String msg;
	CallMe target;
	Thread t;
	int num1 , num2 ;
	
	public Caller(CallMe targ , String s , int num1 , int num2) {
		target = targ;
		msg = s;
		this.num1 = num1;
		this.num2 = num2;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		synchronized (target) {
			target.call(msg);
			target.call(""+target.add(num1, num2));
		}
//		target.call(msg);
//		target.call(""+target.add(num1, num2));
	}
}

public class Synch {
	public static void main(String[] args) {
		CallMe target = new CallMe();
		Caller ob1 = new Caller(target, "Hello",3,4);
		Caller ob2 = new Caller(target, "Synchronized",5,6);
		Caller ob3 = new Caller(target, "World",7,8);
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
}
}
