package cg.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.spring.beans.Employee;

public class App {
    public static void main(String[] args) {
        System.out.println("Application Started!");
        ApplicationContext ac= new ClassPathXmlApplicationContext("springConf.xml");
        Employee e= (Employee) ac.getBean("emp1");
        
        //problem 1.1
        System.out.println("Employee Details");
        System.out.println("-----------------");
        System.out.println("Employee Id: "+ e.getEmployeeId());
        System.out.println("Employee Name: "+ e.getEmployeeName());
        System.out.println("Employee Salary: "+ e.getSalary());
        System.out.println("Employee BU: "+ e.getBusinessUnit());
        System.out.println("Employee Age: "+ e.getAge());
        
        
        
    }
}
