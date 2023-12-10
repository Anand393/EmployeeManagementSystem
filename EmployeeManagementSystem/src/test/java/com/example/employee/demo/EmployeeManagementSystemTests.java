package com.example.employee.demo;


import java.util.List;


import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.employee.EmployeeManagementSystems.model.Employee;
import com.example.employee.EmployeeManagementSystems.repository.EmployeeRepo;
import com.example.employee.EmployeeManagementSystems.service.EmployeeService;

import lombok.Builder;

@AutoConfigureMockMvc
@SpringBootTest

@SpringBootConfiguration
class EmployeeManagementSystemTests {
    
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	// given/when/then format
	@Test
	public void givenEployees_whenGetAllEmployee_thenListOfEmployee() throws Exception {
		
		
		// given - setup or precondition
		
		List<Employee> employees = List.of(Employee.builder().name("Akhil").email("akhil@xyz.com").department("testing").
				joiningDate("12-02-2007").build());
				
		employeeRepo.saveAll(employees);	
				
		
		// when - action
		
	ResultActions response =	mockMvc.perform(MockMvcRequestBuilders.get("/employee/allEmployee" ));
		
		// then - verify the output
	
	response.andExpect(MockMvcResultMatchers.status().isOk());
	response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(employees.size())));
		
		
		
		
		
		
		
	}

}
