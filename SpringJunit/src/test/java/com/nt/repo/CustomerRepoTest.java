package com.nt.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Repositry Layer Test")
class CustomerRepoTest {
	
	//@BeforeAll
	//@AfterAll
	//@DisplayName
	//@Disabled
	//RepeatedTest and TestInfo
	//@Tag
	
	
	@Autowired
	private EmpRepo repo;
	
	@Test
	@Order(1)
	@DisplayName("Add new Customer")
	@Disabled
	void savePerson() {
		Customer cust = new Customer(5, "Traya", "Noida", 1000.10f);
		Customer svaedCust= repo.save(cust);
		
		assertThat(svaedCust.getCno()).isEqualTo(cust.getCno());
	}

	@Test
	@Order(2)
	void isPersonExist() {
		int count = repo.isCustomerExist(5);
		assertThat(count).isGreaterThanOrEqualTo(1);
	}
	
	/*@AfterEach
	void tearDown() {
		System.out.println("CustomerRepoTest.tearDown()");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("CustomerRepoTest.setUp()");
	}*/
	
	//@RepeatedTest(value = 3)
	@DisplayName("Repeated Test")
	@RepeatedTest(value = 3,name="{displayName} - {currentRepetition}/{totalRepetitions} is done")
	void repeatTest(TestInfo info) {
		System.out.println(info.getDisplayName());
	}
	
	@Test
	@Tag("dev")
	void tagTest() {
		System.out.println("dev");
	}
	
	@Test
	@Tag("prod")
	void tagTes2() {
		System.out.println("prod");
	}
	
}










