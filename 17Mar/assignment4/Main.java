package cg.demo.spring.assignment4;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        IEmployeeService service = ac.getBean(IEmployeeService.class);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Insert\n2.Fetch By ID\n3.Display All\n4.Update\n5.Delete\n6.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    service.insert(new Employee(id, name, salary));
                    System.out.println("Inserted");
                    break;

                case 2:
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    Employee emp = service.fetchById(id);
                    System.out.println(emp != null ? emp : "Not found");
                    break;

                case 3:
                    List<Employee> list = service.fetchAll();
                    list.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter id: ");
                    id = sc.nextInt();

                    Employee existing = service.fetchById(id);

                    if (existing != null) {
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        name = sc.nextLine();
                        System.out.print("Enter new salary: ");
                        salary = sc.nextDouble();

                        service.update(new Employee(id, name, salary));
                        System.out.println("Updated successfully");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter id: ");
                    id = sc.nextInt();
                    service.delete(id);
                    break;

                case 6:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}