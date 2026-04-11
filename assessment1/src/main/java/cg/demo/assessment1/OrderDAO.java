package cg.demo.assessment1;

import java.time.LocalDate;
import java.util.List;

import cg.demo.assessment1.entities.Customer;
import cg.demo.assessment1.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface OrderDAO {
	public boolean addOrder(Order order, int custId);
	public Order getOrder(int orderId);
	public List<Order> getOrders(String custName);
}

class OrderDaoImpl implements OrderDAO {

    EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em= emf.createEntityManager();

    @Override
    public boolean addOrder(Order order, int custId) {
        Customer cust= em.find(Customer.class, custId);
        if(cust==null)
            return false;
        order.setOrderDate(LocalDate.now());
        order.setCustomer(cust);
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Order getOrder(int orderId) {
        return em.find(Order.class, orderId);
    }

    @Override
    public List<Order> getOrders(String custName) {
        String jpql= "SELECT o FROM Order o WHERE o.customer.customerName = :name";
        TypedQuery<Order> query= em.createQuery(jpql, Order.class);
        query.setParameter("name", custName);
        return query.getResultList();
    }
}