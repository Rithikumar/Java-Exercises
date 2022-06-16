package com.learn.ch11.interthread;


class SampleThread implements Runnable {
	String name;
	Thread t;
	
	SampleThread(String threadName){
		name = threadName;
		t = new Thread(this,name);
		System.out.println("New Thread: " + t);
		t.start(); // Start the thread
	}
	
	//This is the entry point for thread
	
	public void run() {
		try {
			
			for(int i = 15; i > 0 ; i--){
				System.out.println(name + ": " + i);
				Thread.sleep(200);
			}
		} catch ( InterruptedException e) {
			System.out.println(name + " interrupted.");
		}
		System.out.println(name + " exiting.");
	}
}

public class SuspendResume {
	public static void main(String[] args) {
		SampleThread ob1 = new SampleThread("One");
		SampleThread ob2 = new SampleThread("Two");
		
		try {
			Thread.sleep(1000);
			ob1.t.suspend();
			System.out.println("Suspending thread One");
			Thread.sleep(1000);
			ob1.t.resume();
			System.out.println("Resuming thread One");
			ob2.t.suspend();
			System.out.println("Suspending thread Two");
			Thread.sleep(1000);
			ob2.t.resume();
			System.out.println("Resuming thread two");
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		
		// wait for threads to finish
		try {
			System.out.println("Waiting for threads to finish");
			ob1.t.join();
			ob2.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
	}
}
