package com.example.employee.EmployeeManagementSystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
public class EmployeeManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystem.class, args);
	}

}
