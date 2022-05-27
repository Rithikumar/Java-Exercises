package com.learn.ch6.statics;

/**
 * <p>
 * This Students class has student's details like their name , roll no , college
 * Each variable is given separate memory each time the object is created
 * </p>
 * 
 * @author rithi-zstch1028
 *
 */
class Students {
	
	private String name;// 2bytes per unit
	private int rollNo;// 4bytes
	private String collegeName;// 2bytes per unit

	Students(String name, int rollNo, String collegeName) {
		this.name = name;
		this.rollNo = rollNo;
		this.collegeName = collegeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", rollNo=" + rollNo + ", collegeName=" + collegeName + "]";
	}

}

class Students1 {
	private String name;
	private int rollNo;
	private static String collegeName = "ASM";
	
	Students1(String name , int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}
	
	Students1(String name, int rollNo, String collegeName) {
		this.name = name;
		this.rollNo = rollNo;
		this.collegeName = collegeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", rollNo=" + rollNo + ", collegeName=" + collegeName + "]";
	}

}

public class StaticVariable {
	public static void main(String[] args) {
		Students st1 = new Students("name",9,"ASM"); //Here 18 bytes are taken by the variables 2*4 + 4 + 2*3 = 18
		Students st2 = new Students("cakes",10,"AS M"); // Here 20 bytes are taken by the variable 2*5 + 4 + 2*3 = 20
		//Totally these two object takes 38 bytes
		Students1 sts1 = new Students1("name",9);
		Students1 sts2 = new Students1("name",10,"ABSM");
		System.out.println(sts1.toString());
		//Here sts1 prints out ABSM , This the variable collegeName is not individual for each object and is not created each time
		//thus when sts2 object changed the value sts1 is also reflected.
	}
}
