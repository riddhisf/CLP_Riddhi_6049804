package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entities.Employee;

public interface IEmployeeService {
	Employee insertEmployee(Employee emp);
	List<EmployeeDTO> fetchEmployees();
	List<DepartmentCountDTO> fetchNoOfEmployees();
	List<EmployeeDTO> fetchEmployeesByDept(String name);
	EmployeeDepartmentDTO fetchEmployeeByMobile(String mobile);
}
