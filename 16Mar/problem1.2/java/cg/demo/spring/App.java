package cg.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.spring.beans.Employee;

public class App {
    public static void main(String[] args) {
        System.out.println("Application Started!");
        ApplicationContext ac= new ClassPathXmlApplicationContext("springConf.xml");
        Employee e= (Employee) ac.getBean("emp1");
        
        //problem 1.2
        System.out.println("Employee Details");
        System.out.println("-----------------");
        System.out.println(e);
        
    }
}
