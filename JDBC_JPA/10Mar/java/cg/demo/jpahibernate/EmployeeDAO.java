package cg.demo.jpahibernate;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import cg.demo.jpahibernate.entities.Employee;

public class EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

    // Insert
    public void insertEmployee(Employee emp) {

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

    }

    // Update by ID
    public void updateEmployee(int id, String name, float salary, String dept) {

        Employee emp = em.find(Employee.class, id);

        if(emp != null) {
            em.getTransaction().begin();

            emp.setEname(name);
            emp.setSalary(salary);
            emp.setDept(dept);

            em.getTransaction().commit();
        }

    }

    // Delete by ID
    public void deleteEmployee(int id) {

        Employee emp = em.find(Employee.class, id);

        if(emp != null) {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        }

    }

    // Fetch all employees
    public List<Employee> fetchAllEmployees() {

        String jpql = "SELECT e FROM Employee e";

        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

        return query.getResultList();

    }

    // Fetch by ID
    public Employee fetchEmployeeById(int id) {

        return em.find(Employee.class, id);

    }

    // Fetch by salary
    public List<Employee> fetchEmployeeBySalary(float salary) {

        String jpql = "SELECT e FROM Employee e WHERE e.salary = :sal";

        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

        query.setParameter("sal", salary);

        return query.getResultList();

    }

    // Sorted by salary
    public List<Employee> fetchEmployeesSortedBySalary() {

        String jpql = "SELECT e FROM Employee e ORDER BY e.salary";

        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

        return query.getResultList();

    }

    // Fetch by mobile number
    public List<Employee> fetchEmployeeByMobile(String mobile) {

        String jpql = "SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mob";

        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

        query.setParameter("mob", mobile);

        return query.getResultList();

    }
}