package com.demos.jdbc;

import java.util.List;
import java.util.Scanner;

public class InterfaceLayer {

    public static void display(List<Employee> emps) {
        for(Employee emp : emps) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) throws Exception {
        DataLayer obj = new DataLayer();
        List<Employee> emps;
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1 Create Table");
            System.out.println("2 Insert Employee");
            System.out.println("3 View Employees");
            System.out.println("4 Update Salary");
            System.out.println("5 Delete Employee");
            System.out.println("6 View Employee by ID");
            System.out.println("7 Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
            case 1:
            	try {
            		boolean created = obj.createTable();
                    if(created)
                        System.out.println("Table created successfully");
                    else
                        System.err.println("Table creation failed");
            	}catch(Exception e) {
            		System.err.println("Table already exists");
            	}
                break;
            case 2:
                Employee emp = new Employee();
                int empid;
                while(true) {
                    System.out.print("Enter Employee ID: ");
                    empid = sc.nextInt();
                    if(obj.idExists(empid)) System.err.println("ID already exists. Enter another ID.");
                    else {
                    	emp.setId(empid);
                    	break;
                    };
                }
                sc.nextLine();
                System.out.print("Enter name: ");
                emp.setName(sc.nextLine());
                System.out.print("Enter salary: ");
                emp.setSalary(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter department: ");
                emp.setDepartment(sc.nextLine());
                System.out.print("Enter phone number: ");
                emp.setPhoneno(sc.nextLine());
                emps = obj.insertEmployee(emp);
                if(emps == null || emps.isEmpty())
                    System.err.println("Employee insertion failed");
                else
                    display(emps);
                break;
            case 3:
                emps = obj.getEmployee();
                if(emps == null || emps.isEmpty())
                    System.err.println("No employees found");
                else
                    display(emps);
                break;
            case 4:
                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                System.out.print("Enter new salary: ");
                int salary = sc.nextInt();
                emps = obj.updateSalary(id, salary);
                if(emps == null || emps.isEmpty())
                    System.err.println("Salary update failed or employee not found");
                else
                    display(emps);
                break;
            case 5:
                sc.nextLine();
                System.out.print("Enter employee name to delete: ");
                int idToDel = sc.nextInt();
                emps = obj.deleteEmployee(idToDel);
                if(emps == null || emps.isEmpty())
                    System.err.println("Employee not found");
                else
                    display(emps);
                break;
            case 6:
                System.out.print("Enter Employee ID: ");
                int empId = sc.nextInt();
                emps = obj.getEmployeeById(empId);
                if(emps == null || emps.isEmpty())
                    System.err.println("Employee not found");
                else
                    display(emps);
                break;
            case 7:
            	obj.closeConn();
                System.out.println("Exiting...");
                break;
            default:
                System.err.println("Invalid choice");
            }
        } while(choice != 7);
        sc.close();
    }
}