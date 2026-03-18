package cg.demo.spring.assignment4;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepo repo;

    @Override
    public void insert(Employee emp) {
        repo.insert(emp);
    }

    @Override
    public Employee fetchById(int id) {
        return repo.fetchById(id);
    }

    @Override
    public List<Employee> fetchAll() {
        return repo.fetchAll();
    }

    @Override
    public void update(Employee emp) {
        repo.update(emp);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }
}