package com.example.employee.demo.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employee.EmployeeManagementSystems.impl.EmployeeServiceImpl;
import com.example.employee.EmployeeManagementSystems.model.Employee;
import com.example.employee.EmployeeManagementSystems.repository.EmployeeRepo;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {
	
	@Mock
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private Employee employee;
	
	
	private EmployeeServiceImpl employeeServiceImpl;
	
	@BeforeEach
	void setUp() {
		
		this.employeeServiceImpl=new EmployeeServiceImpl(this.employeeRepo);

	}
	
	@Test
	void addEmployee() {
		
		
		employeeServiceImpl.addEmployee(employee);
		
		verify(employeeRepo).save(employee);
	}
	
	
	@Test
	void removeEmployee() {
		
		int empid = 1;
		
		employeeServiceImpl.removeEmployee(empid);
		
		verify(employeeRepo).deleteById(empid);
	}
	
	@Test
	void findEmployeeById() {
		
		int empid = 1;
		
		employeeServiceImpl.findEmployeeById(empid);
		
		verify(employeeRepo).findById(empid);
	}
	
	
	
	@Test
	void getAllEmployee() {
		
		
		employeeServiceImpl.getAllEmployee();
		
		verify(employeeRepo).findAll();
	}
	
	@Test
	void updatEmployee() {
		
		int empid = 1;
		
		employeeServiceImpl.updateEmployee(empid,employee);
		
		verify(employeeRepo).findById(empid);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
