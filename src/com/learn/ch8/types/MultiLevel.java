package com.learn.ch8.types;

class Student {
	int reg_no;
	
	void putNo(int no) {
		reg_no = no;
	}
	
	void getNo() {
		System.out.println("Registration number = " + reg_no);
	}
}

class Marks extends Student {
	float marks;
	
	void putMarks(float m) {
		marks = m ;
	}
	
	void getMarks() {
		System.out.println("marks = " + marks);
	}
}

class Sports extends Marks {
	float score;
	
	void putScore(float score) {
	
		this.score = score;
	}
	
	void getScore() {
		System.out.println("Score = " + score);
	}

}

public class MultiLevel {
	public static void main(String[] args) {
		Sports ob=new Sports();  
		ob.putNo(987);  
		ob.putMarks(78); 
		ob.putScore(68.7f);  
		ob.getNo();
		ob.getMarks();
		ob.getScore();
		
	}
}
