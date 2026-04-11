package com.example.demo.services;
import java.util.List;

import com.example.demo.dto.EmpDTO;

public interface IEmployeeService {
    List<EmpDTO> getAllEmployees();
    EmpDTO getEmployeeById(Integer id);
    void updateEmployee(Integer id, EmpDTO empDto);
    void deleteEmployee(Integer id);
}