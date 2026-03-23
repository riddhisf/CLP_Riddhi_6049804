package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entities.Employee;
import com.example.demo.services.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping
	public Employee insertEmployee(@Valid @RequestBody Employee emp) {
		return service.insertEmployee(emp);
	}
	
	@GetMapping
	public List<EmployeeDTO> fetchEmployees(){
		return service.fetchEmployees();
	}
	
	@GetMapping("/count")
	public List<DepartmentCountDTO> fetchNoOfEmployees(){
		return service.fetchNoOfEmployees();
	}
	
	@GetMapping("/name/{name}")
	public List<EmployeeDTO> fetchEmployeesByDept(@PathVariable String name){
	    return service.fetchEmployeesByDept(name);
	}
	
	@GetMapping("/mobile/{mobile}")
	public EmployeeDepartmentDTO fetchEmployeeByMobile(@PathVariable String mobile) {
		return service.fetchEmployeeByMobile(mobile);
	}
}
