package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.repo.Customer;
import com.nt.service.CustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getemp/{cid}")
	public ResponseEntity<Customer> getEmp(@PathVariable int cid) {
		
		return new ResponseEntity<>(customerService.getEmp(cid),HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Customer>> getAllEmp(){
		return new ResponseEntity<>(customerService.getAllEmpData(),HttpStatus.OK);
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmp(@RequestBody Customer customer){
		return new ResponseEntity<String>(customerService.saveEmp(customer),HttpStatus.CREATED);
	}

}
