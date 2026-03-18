package cg.demo.spring.assignment4;

import java.util.List;

public interface IEmployeeService {
    void insert(Employee emp);
    Employee fetchById(int id);
    List<Employee> fetchAll();
    void update(Employee emp);
    void delete(int id);
}