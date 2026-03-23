package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.IEmployeeRepo;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	IEmployeeRepo repo;

	@Override
	public Employee insertEmployee(Employee emp) {
		return (Employee)repo.save(emp);
	}

	@Override
	public List<EmployeeDTO> fetchEmployees() {
		List<Employee> list=  repo.findAll();
		
	    List<EmployeeDTO> dtoList = new ArrayList<>();
	    
	    for (Employee e : list) {
	        dtoList.add(new EmployeeDTO(
	            e.getId(),
	            e.getEname(),
	            e.getSalary(),
	            e.getDepartment().getName(),
	            e.getMobileNumbers()
	        ));
	    }

	    return dtoList;
		
	}

	@Override
	public List<DepartmentCountDTO> fetchNoOfEmployees() {
		return repo.getNoOfEmployees();
	}

	@Override
	public List<EmployeeDTO> fetchEmployeesByDept(String name) {
		return repo.getEmployeeByDeptName(name);
	}

	@Override
	public EmployeeDepartmentDTO fetchEmployeeByMobile(String mobile) {
		return repo.getEmployeeByMobile(mobile);
	}

}
