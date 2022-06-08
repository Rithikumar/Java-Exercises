package com.learn.ch11.creation;

class Alive implements Runnable{
	String name;
	Thread t;

	Alive(String threadname) {
		name = threadname;
		t = new Thread(this , name);
		System.out.println("New Thread: " + t);
		t.start();
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + " interrupted");
		}
		System.out.println(name + " exiting.");
	}
}

public class IsAlive {
		public static void main(String[] args) {
			Alive p1 = new Alive("one");
			Alive p2 = new Alive("two");
			Alive p3 = new Alive("three");
			
			System.out.println("Thread One is alive: " + p1.t.isAlive());
			System.out.println("Thread Two is alive: " + p2.t.isAlive());
			System.out.println("Thread Three is alive: " + p3.t.isAlive());
			
			// wait for threads to finish
			
			try {
				System.out.println("Waiting for threads to finish.");
				p1.t.join();
				p2.t.join();
				p3.t.join();
			} catch (InterruptedException e) {
				System.out.println("Main thread Interrupted");
			}
			
			System.out.println("Thread One is alive: " + p1.t.isAlive());
			System.out.println("Thread Two is alive: " + p2.t.isAlive());
			System.out.println("Thread Three is alive: " + p3.t.isAlive());

			System.out.println("Main thread exiting");
		}
}

