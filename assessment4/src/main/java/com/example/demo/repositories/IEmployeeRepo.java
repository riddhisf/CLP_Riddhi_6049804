package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer>{

}
