package cg.demo.jpahibernate;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import cg.demo.jpahibernate.entities.*;

public class EmployeeDAO {

    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
    private EntityManager em=emf.createEntityManager();
    private CriteriaBuilder cb = em.getCriteriaBuilder();

    public void insertEmployee(Employee emp){
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public List<Employee> fetchEmployees(){
        //String jpql="SELECT e FROM Employee e JOIN e.department";
        //TypedQuery<Employee> query=em.createQuery(jpql,Employee.class);
    	
    	CriteriaQuery<Employee> cq= cb.createQuery(Employee.class);
    	Root<Employee> root = cq.from(Employee.class);
    	cq.select(root);
    	TypedQuery<Employee> query= em.createQuery(cq);
        return query.getResultList();
    }

    public List<Object []> countEmployees(){
        //String jpql="SELECT d.name,COUNT(e) FROM Employee e JOIN e.department d GROUP BY d.name";
        //TypedQuery<Object[]> query=em.createQuery(jpql,Object[].class);

	    CriteriaQuery<Object[]> cq=cb.createQuery(Object[].class);
	    Root<Employee> root=cq.from(Employee.class);
	    Join<Employee,Department> joinED=root.join("department");
	    cq.multiselect(joinED.get("name"),cb.count(root));
	    cq.groupBy(joinED.get("name"));
	    TypedQuery<Object[]> query=em.createQuery(cq);
	    return query.getResultList();
	}

    public List<Employee> employeesByDept(String deptName){
        //String jpql="SELECT e FROM Employee e JOIN e.department d WHERE d.name=:dname";
        //TypedQuery<Employee> query=em.createQuery(jpql,Employee.class);
        //query.setParameter("dname",deptName);
    	
        CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
        Root<Employee> emp=cq.from(Employee.class);
        Join<Employee,Department> dept=emp.join("department");
        Predicate condition=cb.equal(dept.get("name"),deptName);
        cq.select(emp).where(condition);
        TypedQuery<Employee> query=em.createQuery(cq);
        return query.getResultList();
    }

    public Object[] departmentByMobile(String mobile){
        //String jpql="SELECT e.id,e.ename,d.name,d.managerName FROM Employee e JOIN e.department d JOIN e.mobileNumbers m WHERE m=:num";
        //TypedQuery<Object[]> query=em.createQuery(jpql,Object[].class);
        //query.setParameter("num",mobile);
    	
    	CriteriaQuery<Object[]> cq=cb.createQuery(Object[].class);
        Root<Employee> root=cq.from(Employee.class);
        Join<Employee,Department> joinED=root.join("department");
        Join<Employee,String> joinMobile=root.join("mobileNumbers");
        Predicate condition=cb.equal(joinMobile,mobile);
        cq.multiselect(root.get("id"),root.get("ename"),joinED.get("name"),joinED.get("managerName")).where(condition);
        TypedQuery<Object[]> query=em.createQuery(cq);
        return query.getSingleResult();
    }
}