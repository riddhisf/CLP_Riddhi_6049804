package cg.demo.jpahibernate.entities;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @Column(name="dname")
    private String name;

    @Column(name="manager")
    private String managerName;

    @OneToMany(mappedBy="department", cascade=CascadeType.ALL)
    private Set<Employee> employees;

    public Department() {}

    public int getDeptId() {
        return deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}