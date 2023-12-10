package com.example.employee.EmployeeManagementSystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.employee.EmployeeManagementSystems.security.JwtAuthenticationEntry;
import com.example.employee.EmployeeManagementSystems.security.JwtAuthenticationFilter;


@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntry point;
	@Autowired
	private JwtAuthenticationFilter filter;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		http.csrf(csrf-> csrf.disable())
		             .cors(cors-> cors.disable())
		             .authorizeHttpRequests(auth-> auth.requestMatchers("/employee/**")
		             .authenticated().requestMatchers("/auth/login")
		             .permitAll().anyRequest().authenticated())
		             .exceptionHandling(ex->ex.authenticationEntryPoint(point))
		             .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		
		
		;
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

}
