package com.nt;

public class ProductCatalog {
	
	private Math math;

	public ProductCatalog(Math math) {
		this.math = math;
	}
	
	public String getCatalog(int a , int b) {
		return "final is "+ math.add(a, b);
	}
	
	

}
