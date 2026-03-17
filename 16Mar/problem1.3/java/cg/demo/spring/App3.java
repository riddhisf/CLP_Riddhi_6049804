package cg.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.spring.beans3.Employee;
import cg.demo.spring.beans3.SBU;

public class App3 {
    public static void main(String[] args) {
        System.out.println("Application Started!");
        ApplicationContext ac= new ClassPathXmlApplicationContext("springConf.xml");
        SBU sbu= (SBU) ac.getBean("sbu2");
        
        //problem 1.2
        System.out.println("Employee Details");
        System.out.println("-----------------");
        System.out.println(sbu);
        
    }
}
