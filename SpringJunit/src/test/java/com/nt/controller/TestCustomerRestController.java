package com.nt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations ="classpath:application.properties")
@DisplayName("Customer Rest Controller Test")
public class TestCustomerRestController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Get one Emp")
	public void testGetEmp() throws Exception {
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/getemp/1");
		
		MvcResult result= mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response= result.getResponse();
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
		assertNotNull(response.getContentAsString());
		
		if(!response.getContentType().contains("application/json"))
			fail("May be not json Data");
	}
	
	@Test
	@DisplayName("Get All results")
	public void testGetAllEmp() throws Exception {
		
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get("/getAllEmp");
		MvcResult result= mockMvc.perform(request).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertNotNull(response.getContentAsString());
		if(!response.getContentType().contains("application/json"))
			fail("May be not json Data");
		
		log.info(response.getContentAsString());
	}
	
	@Test
	public void testSaveEmp() throws Exception {
		MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post("/saveEmp").header("Content-Type", "application/json")
		.content("{\r\n"
				+ "    \"cno\":\"7\",\r\n"
				+ "    \"cname\":\"Gautam\",\r\n"
				+ "    \"cadd\":\"Patna\",\r\n"
				+ "    \"cbill\":20000\r\n"
				+ "}");
		MvcResult result= mockMvc.perform(request).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		assertNotNull(response.getContentAsString());
		log.info(response.getContentAsString());
	}
}


















