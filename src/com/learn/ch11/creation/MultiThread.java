package com.learn.ch11.creation;

class SecondThread implements Runnable {
	String name; // name of thread
	Thread t;
	
	SecondThread(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New Thread: " + t);
		t.start(); // Start the thread
	}
	
	//This is the entry point of the thread.
	public void run() {
		try {
			for(int i = 5; i> 0 ; i-- ) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + "Interrupted");
		}
		System.out.println(name + "Exiting.");
	}
}
public class MultiThread {
	public static void main(String[] args) {
		new SecondThread("One");
		new SecondThread("Two");
		new SecondThread("Three");
		
		try {
			// wait for other threads to end
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Main Thread exiting");
	}
}
