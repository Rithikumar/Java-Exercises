package com.learn.ch8;

class Shipment extends BoxWeight1 {
	double cost;
	
	Shipment(Shipment object){
		super(object);
		cost = object.cost;
	}

	Shipment(double w, double h, double d, double m, double c) {
		super(w, h, d, m);
		cost = c;
	}
	
	Shipment(){
		super();
		cost= -1;
	}
	
	Shipment(double len , double m , double c) {
		super(len, m);
		cost = c;
	}
	
}

public class DemoShipment {
	public static void main(String[] args) {
		Shipment sh1 = new Shipment(10,20,15,10,3.41);
		Shipment sh2 = new Shipment(2,3,4,0.76, 1.28);
		
		System.out.println("Volume of the shipment1 "+sh1.volume());
		System.out.println("Weight of the shipment1 "+sh1.weight);
		System.out.println("Shipping cost: $ "+sh1.cost);
		System.out.println();
		
		System.out.println("Volume of the shipment2 "+sh2.volume());
		System.out.println("Weight of the shipment2 "+sh2.weight);
		System.out.println("Shipping cost: $ "+sh2.cost);
		System.out.println();
	}
}
