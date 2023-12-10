package com.nt;

public class Calculator {
	
	public int getSum(int... a) {
		int sum =0;
		
		for(int s : a) {
			sum =sum +s;
		}
		return sum;
	}
	
	public int getProd(int... a) {
		int sum =1;
		
		for(int s : a) {
			sum =sum *s;
		}
		return sum;
	}

}
