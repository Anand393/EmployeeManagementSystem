package com.example.employee.EmployeeManagementSystems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.EmployeeManagementSystems.impl.EmployeeServiceImpl;
import com.example.employee.EmployeeManagementSystems.model.Employee;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empservice;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		
		Employee emp = empservice.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/removeEmployee/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id){
		
		empservice.removeEmployee(id);
		return new ResponseEntity<String>("Employee Removed Successfully !!!", HttpStatus.ACCEPTED); 
	}
	
	@GetMapping("/findEmployee/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
		
		Optional<Employee> emps = empservice.findEmployeeById(id);
		return new ResponseEntity<Optional<Employee>>(emps,HttpStatus.ACCEPTED);
		
	}
	 
	@GetMapping("/allEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> lemp = empservice.getAllEmployee();
		return new ResponseEntity<List<Employee>>(lemp, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<String> updateEmloyee(@PathVariable int id, @RequestBody Employee employee) {
		 
		empservice.updateEmployee(id,employee);
		return new ResponseEntity<String>("Employee Updated !!", HttpStatus.ACCEPTED);
		
	}
	
	
}
	
	


