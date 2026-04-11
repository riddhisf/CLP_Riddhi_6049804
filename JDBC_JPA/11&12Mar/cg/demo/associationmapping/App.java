package cg.demo.jpahibernate;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeUI ui = new EmployeeUI();

        while(true) {
            System.out.println("1 Insert Employee");
            System.out.println("2 Fetch Employees");
            System.out.println("3 Count Employees by Department");
            System.out.println("4 Employees by Department Name");
            System.out.println("5 Department by Mobile Number");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1: ui.insertEmployee(); break;
                case 2: ui.fetchEmployees(); break;
                case 3: ui.countEmployees(); break;
                case 4: ui.employeesByDept(); break;
                case 5: ui.departmentByMobile(); break;
                case 6: System.exit(0);
                default: System.err.println("Enter Valid Choice");
            }
        }
    }
}