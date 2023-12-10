package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.Customer;
import com.nt.repo.EmpRepo;

@Service
public class CustomerService {
	
	@Autowired
	private EmpRepo empRepo;
	
	public Customer getEmp(int cid) {
		return empRepo.getCustomer(cid);
	}
	
	public List<Customer> getAllEmpData(){
		return empRepo.findAll();
	}

	public String saveEmp(Customer customer) {
		Customer cust = empRepo.save(customer);
		return "Customer data saved with id "+ cust.getCno();
	}

}
