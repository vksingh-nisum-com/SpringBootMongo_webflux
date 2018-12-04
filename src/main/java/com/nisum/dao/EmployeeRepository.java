package com.nisum.dao;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.nisum.model.Employee;
@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, String> {
	
}

	
	


