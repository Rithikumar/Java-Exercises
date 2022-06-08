package com.learn.ch11.creation;

class clicker implements Runnable {
	long click = 0 ; 
	Thread t ;
	private volatile boolean running = true;
	
	public clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}
	
	public void run() {
		while(running) {
			click++;
		}
	}
	
	public void stop() {
		running = false;
	}
	
	public void start() {
		t.start();
	}
}
public class Priority {
	public static void main(String[] args) {
		clicker high = new clicker(Thread.MAX_PRIORITY);
		clicker low = new clicker(Thread.NORM_PRIORITY - 2);
		
		low.start();
		high.start();
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrputed.");
		}
		
		low.stop();
		high.stop();
				
		try {
			high.t.join();
			low.t.join();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		
		System.out.println("Low-priority thread: " + low.click);
		System.out.println("High-priority thread: " + high.click);
	}
}
