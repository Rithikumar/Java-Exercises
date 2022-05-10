package com.learn.ch7;

/**
 * Practicing overloading constructors
 * @author rithi-zstch1028
 *
 */
class OverloadingBox{
	double width;
	double height;
	double depth;
	
	//This is constructor
	OverloadingBox(double w , double h , double d) {
		width = w;
		height = h;
		depth = d;
	}
	
	//another overoading 
	OverloadingBox(){
		width = -1;// was -i to indicate
		height = -1;//
		depth = -1;
	}
	
	OverloadingBox(double len){
		width = height = depth = len;
	}
	
	double volume() {
		return width * height * depth;
	}
}

/**
 * <p>Create to check the overloading constructors</p>
 * @author rithi-zstch1028
 *
 */
public class OverloadConstruct {
	
	public static void main(String[] args) {
		OverloadingBox b = new OverloadingBox(10,20,25);
		OverloadingBox b1 = new OverloadingBox();
		OverloadingBox b2 = new OverloadingBox(7);
		
		System.out.println(b.volume());
		System.out.println(b1.volume());
		System.out.println(b2.volume());
	}
}








