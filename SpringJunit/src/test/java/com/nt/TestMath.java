package com.nt;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestMath {
	
	@Test
	public void testAdd() {
		Math math = mock(Math.class);
		when(math.add(10, 11)).thenReturn(21);
	}
	

}
