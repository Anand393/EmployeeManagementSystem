package com.example.employee.EmployeeManagementSystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.employee.EmployeeManagementSystems.model.Employee;

@Service
@ComponentScan
public interface EmployeeService {

	
	public Employee addEmployee(Employee employee);
	public String removeEmployee(int id);
	public List<Employee> getAllEmployee();
	public Optional<Employee> findEmployeeById(int id);
	public Employee updateEmployee(int id, Employee employee);
	
}
