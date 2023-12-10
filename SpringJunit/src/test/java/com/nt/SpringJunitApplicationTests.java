package com.nt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SpringJunitApplicationTests {
	
	
	private Calculator cal= new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum() {
		int actualSum=cal.getSum(1,2,3);
		int expectedSum = 6;
		assertThat(actualSum).isEqualTo(expectedSum);
	}

}
