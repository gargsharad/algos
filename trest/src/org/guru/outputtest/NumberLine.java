package org.guru.outputtest;

public class NumberLine {

	public static void main(String ap[]) {

		printNum(7);
	}

	private static void printNum(int i) {

		if(i == 0){
			return;
		}
		
		System.out.println(" "+i);
		printNum(--i);
		System.out.println(" "+i);
	}
}
