package cg.demo.jpahibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cg.demo.jpahibernate.entities.Employee;

public class EmployeeUI {

    static Scanner sc = new Scanner(System.in);
    static EmployeeDAO dao = new EmployeeDAO();

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1 Insert Employee");
            System.out.println("2 Update Employee");
            System.out.println("3 Delete Employee");
            System.out.println("4 Fetch All Employees");
            System.out.println("5 Fetch Employee By ID");
            System.out.println("6 Fetch Employee By Salary");
            System.out.println("7 Fetch Employees Sorted By Salary");
            System.out.println("8 Fetch Employee By Mobile");
            System.out.println("9 Exit");

            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    fetchAll();
                    break;
                case 5:
                    fetchById();
                    break;
                case 6:
                    fetchBySalary();
                    break;
                case 7:
                    fetchSorted();
                    break;
                case 8:
                    fetchByMobile();
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    static void insertEmployee() {
        Employee emp = new Employee();

        System.out.println("Enter Name");
        emp.setEname(sc.next());

        System.out.println("Enter Salary");
        emp.setSalary(sc.nextFloat());

        System.out.println("Enter Department");
        emp.setDept(sc.next());

        Set<String> mobiles = new HashSet<>();

        System.out.println("Enter number of mobile numbers");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
        	System.out.println("Enter mobile number:");
            mobiles.add(sc.next());
        }

        emp.setMobileNumbers(mobiles);
        dao.insertEmployee(emp);
    }

    static void updateEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();

        System.out.println("Enter Name");
        String name = sc.next();

        System.out.println("Enter Salary");
        float salary = sc.nextFloat();

        System.out.println("Enter Department");
        String dept = sc.next();

        dao.updateEmployee(id,name,salary,dept);
    }

    static void deleteEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();

        dao.deleteEmployee(id);
    }

    static void fetchAll() {
        List<Employee> list = dao.fetchAllEmployees();

        for(Employee e : list) {
            display(e);
        }
    }

    static void fetchById() {
        System.out.println("Enter ID");
        int id = sc.nextInt();

        Employee e = dao.fetchEmployeeById(id);

        if(e!=null) {
            display(e);
        }
    }

    static void fetchBySalary() {
        System.out.println("Enter Salary");
        float sal = sc.nextFloat();

        List<Employee> list = dao.fetchEmployeeBySalary(sal);

        for(Employee e : list) {
            display(e);
        }
    }

    static void fetchSorted() {
        List<Employee> list = dao.fetchEmployeesSortedBySalary();

        for(Employee e : list) {
            display(e);
        }
    }

    static void fetchByMobile() {
        System.out.println("Enter Mobile Number");
        String mob = sc.next();

        List<Employee> list = dao.fetchEmployeeByMobile(mob);

        for(Employee e : list) {
            display(e);
        }
    }

    //helper method
    static void display(Employee e) {
        System.out.println(
                e.getId()+" "+
                e.getEname()+" "+
                e.getSalary()+" "+
                e.getDept()+" "+
                e.getMobileNumbers()
        );
    }
}