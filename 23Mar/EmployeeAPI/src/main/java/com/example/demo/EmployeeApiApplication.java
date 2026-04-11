package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Employee;
import com.example.demo.controllers.EmployeeController;
import com.example.demo.dto.DepartmentCountDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.EmployeeDepartmentDTO;
import com.example.demo.entities.Department;

@SpringBootApplication
public class EmployeeApiApplication implements CommandLineRunner {

    @Autowired
    private EmployeeController controller;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Fetch All Employees");
            System.out.println("3. Count Employees by Department");
            System.out.println("4. Fetch Employees by Department Name");
            System.out.println("5. Fetch Employee by Mobile Number");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        Employee emp = new Employee();
                        Department dept = new Department();
                        //input
                        System.out.print("Enter Name: ");
                        emp.setEname(sc.next());
                        System.out.print("Enter Salary: ");
                        emp.setSalary(sc.nextFloat());
                        System.out.print("Enter number of mobile numbers: ");
                        int n = sc.nextInt();
                        Set<String> mobiles = new HashSet<>();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter mobile number: ");
                            mobiles.add(sc.next());
                        }
                        emp.setMobileNumbers(mobiles);
                        System.out.print("Enter Department Name: ");
                        dept.setName(sc.next());
                        System.out.print("Enter Manager Name: ");
                        dept.setManagerName(sc.next());
                        emp.setDepartment(dept);
                        
                        //controller call
                        Employee result = controller.insertEmployee(emp);
                        
                        //output
                        System.out.println("Employee Inserted Successfully!");
                        System.out.println(result);
                        break;

                    case 2:
                        //controller call
                        List<EmployeeDTO> list = controller.fetchEmployees();
                        
                        //output
                        if (list == null || list.isEmpty()) {
                            System.err.println("No employees found!");
                        } else {
                            for (EmployeeDTO e : list) {
                                System.out.println(e);
                            }
                        }
                        break;

                    case 3:
                        //controller call
                        List<DepartmentCountDTO> results= controller.fetchNoOfEmployees();

                        //output
                        if (results == null || results.isEmpty()) {
                            System.err.println("No department data found!");
                        } else {
                            for (DepartmentCountDTO count : results) {
                                System.out.println(count);
                            }
                        }
                        break;

                    case 4:
                        //input
                        System.out.print("Enter Department Name: ");
                        String dname = sc.next();
                        
                        //controller call
                        List<EmployeeDTO> deptList = controller.fetchEmployeesByDept(dname);
                        
                        //output
                        if (deptList == null || deptList.isEmpty()) {
                            System.err.println("No employees found for this department!");
                        } else {
                            for (EmployeeDTO e : deptList) {
                                System.out.println(e);
                            }
                        }
                        break;

                    case 5:
                        //input
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.next();
                        
                        //controller call
                        EmployeeDepartmentDTO e = controller.fetchEmployeeByMobile(mobile);
                        
                        //output
                        if (e != null) {
                            System.out.println(e);
                        } else {
                            System.err.println("No employee found!");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}