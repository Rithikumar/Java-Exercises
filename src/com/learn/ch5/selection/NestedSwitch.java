package com.learn.ch5.selection;

public class NestedSwitch {
	public static void main(String[] args) {
		int count =1;
		int target = 0;
		switch(count) {
		case 1:
				switch(target) {
				case 0:
					System.out.println("target is zero");
					break;
				case 1: //no conflicts
					System.out.println("target is one");
					break;
				}
		case 2:
			switch(target) {
			case 0:
				System.out.println("target is zero");
				break;
			case 1: //no conflicts
				System.out.println("target is one");
				break;
			}
		}
	}

}
