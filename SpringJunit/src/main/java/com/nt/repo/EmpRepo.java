package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepo extends JpaRepository<Customer,Integer>{
	
	@Query("FROM com.nt.repo.Customer WHERE cno = :cno")
	public Customer getCustomer(int cno);
	
	@Query("SELECT COUNT(*) FROM com.nt.repo.Customer WHERE cno= :cno")
	public int isCustomerExist(int cno);

}
