package com.example.employee.EmployeeManagementSystems.model;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Employee {
	
	
	

@jakarta.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 
@Size(min = 2, message = "Name should not be empty")
@NotEmpty
 private String name;
 
 @Email(message = "Please check the format for the email")
 private String email;
 
 @Size(min = 2, message = "Department should not be empty")
 @NotEmpty
 private String department;
 
 
 private String joiningDate;


}
 
 
	
	
	

