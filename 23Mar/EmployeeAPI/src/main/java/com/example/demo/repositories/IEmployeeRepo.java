package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entities.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT new com.example.demo.dto.DepartmentCountDTO (d.name,COUNT(e)) FROM Employee e JOIN e.department d GROUP BY d.name")
	List<DepartmentCountDTO> getNoOfEmployees();
	
	@Query("SELECT new com.example.demo.dto.EmployeeDTO(e.id, e.ename, e.salary, d.name) FROM Employee e JOIN e.department d WHERE d.name = :name")
	List<EmployeeDTO> getEmployeeByDeptName(String name);
	
	@Query("SELECT new com.example.demo.dto.EmployeeDepartmentDTO(e.id,e.ename,d.name,d.managerName) FROM Employee e JOIN e.department d JOIN e.mobileNumbers m WHERE m=:num")
	EmployeeDepartmentDTO getEmployeeByMobile(String num);
	
}
