package cg.demo.jpahibernate;

import java.util.*;
import cg.demo.jpahibernate.entities.*;

public class EmployeeUI {

    Scanner sc = new Scanner(System.in);
    EmployeeDAO dao = new EmployeeDAO();

    public void insertEmployee() {
        Employee e = new Employee();
        Department d = new Department();

        System.out.println("Enter name");
        e.setEname(sc.next());

        System.out.println("Enter salary");
        e.setSalary(sc.nextFloat());

        System.out.println("Enter department name");
        d.setName(sc.next());

        System.out.println("Enter manager name");
        d.setManagerName(sc.next());

        Set<String> mobiles = new HashSet<>();
        System.out.println("Enter number of mobiles");
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
        	System.out.println("Enter mobile number:");
            mobiles.add(sc.next());
        }
        
        e.setMobileNumbers(mobiles);
        e.setDepartment(d);

        dao.insertEmployee(e);
        System.out.println("Employee inserted successfully");
    }

    public void fetchEmployees(){
        List<Employee> list=dao.fetchEmployees();

        for(Employee e:list){
            System.out.println("Employee Id: "+e.getId());
            System.out.println("Name: "+e.getEname());
            System.out.println("Salary: "+e.getSalary());
            System.out.println("Department: "+e.getDepartment().getName());
            System.out.println("Manager: "+e.getDepartment().getManagerName());

            System.out.println("Mobile Numbers:");
            for(String m:e.getMobileNumbers()){
                System.out.println(m);
            }
        }
    }

    public void countEmployees(){
        List<Object[]> result=dao.countEmployees();
        for(Object[] row:result)
            System.out.println("Department: "+row[0]+" Employee Count: "+row[1]);
    }

    public void employeesByDept() {
        System.out.println("Enter department name");
        String dept = sc.next();
        List<Employee> list = dao.employeesByDept(dept);
        for(Employee e : list)
            System.out.println(e.getId()+" "+e.getEname());
    }

    public void departmentByMobile(){
        System.out.println("Enter mobile number");
        String mobile=sc.next();

        Object[] result=dao.departmentByMobile(mobile);

        System.out.println("Employee Id: "+result[0]);
        System.out.println("Employee Name: "+result[1]);
        System.out.println("Department: "+result[2]);
        System.out.println("Manager: "+result[3]);
    }
}