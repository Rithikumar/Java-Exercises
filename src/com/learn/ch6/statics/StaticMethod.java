package com.learn.ch6.statics;

/**
 * <p>The is an example of static method</p>
 * @author rithi-zstch1028
 *
 */
class Plane {
	private int height;
	private int width;
	
	Plane(int height , int width){
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
}

public class StaticMethod {
	
	public static void main(String[] args) {
		//Main usages of static method is calling it with out object , thus reducing the memory space
		Plane.add(14, 23);//Here 37 is printed
		Plane a = new Plane(23,14);
		a.add(2, 3);//here 37 is printed but it also has a useless value of 13 and 14
	}

}
