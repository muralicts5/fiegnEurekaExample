package com.example.testClient.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.testClient.model.Employee;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Component
@FeignClient(path = "http://localhost:8090")  
public interface EmployeeServiceClient {

	
	
	@GetMapping("/employees")
    List<Employee> findAll();

	@PostMapping("/employees")
	@Headers("Content-Type: application/json")
    void create(Employee employee);
    
    
}
