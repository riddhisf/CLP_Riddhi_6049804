package com.example.demo.entities;

import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @NotEmpty(message = "Department Name cannot be empty!")
    @Column(name="dname")
    private String name;

    @NotEmpty(message = "Manager Name cannot be empty!")
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

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", managerName=" + managerName + "]";
	}
    
}