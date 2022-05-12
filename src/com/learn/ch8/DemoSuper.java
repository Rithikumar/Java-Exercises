package com.learn.ch8;

/**
 * <p>A complete implementation of boxweight</p>
 * @author rithi-zstch1028
 *
 */
class NewBox {
	private double width;
	private double height;
	private double depth;
	
	NewBox(NewBox ob) {
		width = ob.width;
		height = ob.height;
		depth = ob.depth;
	}
	
	NewBox(double w,double h , double d){
		width = w;
		height = h;
		depth = d;
	}
	
	NewBox() {
		width = -1;
		height = -1;
		depth = -1;
	}
	
	NewBox(double len) {
		width = height = depth = len;
	}

	double volume() {
		return width * height * depth;
	}
}

class BoxWeight1 extends NewBox {
	double weight;
	
	BoxWeight1 (BoxWeight1 ob) {
		super(ob);
		weight = ob.weight;
	}
	
	BoxWeight1(double w , double h , double d , double m){
		super(w,h,d);
		weight = m;
	}
	
	BoxWeight1(){
		super();
		weight = -1;
	}
	
	BoxWeight1(double len, double m){
		super(len);
		weight = m;
	}
}

public class DemoSuper {
	public static void main(String[] args) {
		BoxWeight1 mybox1 = new BoxWeight1(10,20,15,34.3);
		BoxWeight1 mybox2 = new BoxWeight1(2,3,4,0.076);
		BoxWeight1 mybox3 = new BoxWeight1();
		BoxWeight1 mycube = new BoxWeight1(3,2);
		BoxWeight1 myclone = new BoxWeight1(mybox1);
	
		System.out.println("Volume of mybox1 is " + mybox1.volume());
		System.out.println("Weight of mybox1 is " + mybox1.weight);
		
		System.out.println("Volume of mybox2 is " + mybox2.volume());
		System.out.println("Weight of mybox2 is " + mybox2.weight);
		
		System.out.println("Volume of mybox3 is " + mybox3.volume());
		System.out.println("Weight of mybox3 is " + mybox3.weight);
		
		System.out.println("Volume of mycube is " + mycube.volume());
		System.out.println("Weight of mycube is " + mycube.weight);
		
		System.out.println("Volume of myclone is " + myclone.volume());
		System.out.println("Weight of myclone is " + myclone.weight);
	}
}






