package cg.demo.assessment1;

import java.util.List;
import java.util.Scanner;

import cg.demo.assessment1.entities.Customer;
import cg.demo.assessment1.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoClient {

    static OrderDAO dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
    static EntityManager em= emf.createEntityManager();

    public static void main(String[] args) {

        String opt = null;
        do {
            System.out.println("1--ADD ORDER");
            System.out.println("2--VIEW BY ORDER ID");
            System.out.println("3--VIEW BY CUSTOMER NAME");
            int mtype = scan.nextInt();
            processMenu(mtype);
            System.out.println("press y to continue");
            opt = scan.next();
        } while(opt.equalsIgnoreCase("y"));
    }
    
    public static void processMenu(int mtype) {
        switch(mtype) {
        case 1:
            addOrder();
            break;
        case 2:
            viewOrderByOrderID();
            break;
        case 3:
            viewOrdersByCustName();
            break;
        default:
            System.out.println("Invalid option");
        }
    }

    public static void addOrder() {
        Order order= new Order();

        System.out.println("Enter Customer Id:");
        int id= scan.nextInt();
        System.out.println("Enter Order Amount:");
        order.setOrderAmt(scan.nextDouble());

        boolean orderAdded= dao.addOrder(order, id);
        if(orderAdded) System.out.println("Order Added Successfully!!");
        else System.out.println("Transaction Unsuccessful!!");
    }

    public static void viewOrderByOrderID() {
        System.out.println("Enter Order ID:");
        int id = scan.nextInt();
        Order order = dao.getOrder(id);
        System.out.println(order);
    }

    public static void viewOrdersByCustName() {
        System.out.println("Enter Customer Name:");
        String name = scan.next();
        List<Order> orders = dao.getOrders(name);
        orders.forEach(System.out::println);
    }
}