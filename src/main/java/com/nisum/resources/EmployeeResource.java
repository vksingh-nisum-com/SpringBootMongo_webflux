package com.nisum.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.dao.EmployeeRepository;
import com.nisum.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeResource {
	@Autowired
	private  EmployeeRepository employeeRepository;
	
	 @GetMapping("/employees")
    public Flux<Employee> getAll() {
        return employeeRepository
                .findAll();
    }	 
	 @GetMapping("/employee/{id}")
	    public Mono<Employee> getId(@PathVariable("id") final String empId) {
	        return employeeRepository.findById(empId);
	    } 
	 @PostMapping("/employee")
	    public Mono<Employee> save(@RequestBody Employee employee) {
	        return employeeRepository.save(employee);
	    } 
	 @PostMapping("/employees")
	    public Flux<Employee> saveAll(@RequestBody Flux<Employee> entities) {
	        return employeeRepository.saveAll(entities);
	    } 
	 @DeleteMapping("/employee/{id}")
	    public Mono<Void> delete(@PathVariable("id") final String id) {
	        return employeeRepository.deleteById(id);
	       // employeeRepository
	    } 
	 @PutMapping("/employee/{id}")
	 public Mono<Employee> update(@RequestBody Employee employee,@PathVariable("id") final String id){
		  employeeRepository.deleteById(id);
		 return employeeRepository.save(employee); 
		
	 }
	 
	

}
