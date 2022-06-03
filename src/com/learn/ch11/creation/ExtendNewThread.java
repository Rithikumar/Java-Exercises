package com.learn.ch11.creation;

/**
 * <p>Creating a thread</p>
 * <p>Create a second thread by extending Thread</p>
 * @author rithi-zstch1028
 *
 */
class FirstThread extends Thread {
	
	FirstThread() {
		// create a new , second thread
		super("Demo Thread");
		System.out.println("Child thread: " + this);
		start(); // Start the thread
		//run(); //gives full access to this class
	}
	
	//This is the entry point for the second thread
	public void run() {
		try {
			for(int i = 5 ; i > 0 ; i-- ) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Child interrupted");
		}
		System.out.println("Exiting child thread");
	}
}

public class ExtendNewThread {
	public static void main(String[] args) {
		new FirstThread();
		
		try {
			for(int i = 5 ; i > 0 ; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread exiting");
	}
	
}
