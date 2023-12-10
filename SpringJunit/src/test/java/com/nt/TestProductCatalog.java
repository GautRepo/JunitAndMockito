package com.nt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestProductCatalog {
	
	private ProductCatalog prod;
	
	private int mrp,vat;
	
	@Mock
	private Math math;

	@Test
	public void testFindTotal() {
		MockitoAnnotations.initMocks(this);
		vat=10;
		mrp=20;
		when(math.add(vat, mrp)).thenReturn(vat+mrp);
		
		prod = new ProductCatalog(math);
		String actual =prod.getCatalog(vat, mrp);
		String expected ="final is 30";
		assertEquals(expected,actual);
		
		
	}
}
