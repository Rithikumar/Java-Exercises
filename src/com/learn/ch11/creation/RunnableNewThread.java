package com.learn.ch11.creation;

/**
 * <p>Creating a second thread.<p>
 * @author rithi-zstch1028
 *
 */
class NewThread implements Runnable {
	Thread t;
	
	NewThread() {
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start(); // start the thread
	}
	
	// This is the entry point for the second thread
	public void run() {
		try {
			for(int i = 5 ; i > 0 ; i-- ) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread");
	}
}

public class RunnableNewThread {
	public static void main(String[] args) {
		new NewThread();
		
		try {
			for(int i = 5; i > 0 ; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Maon thread exiting");
	}
}
