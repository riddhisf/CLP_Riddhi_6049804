package com.example.demo.entities;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private int id;

    @NotEmpty(message = "Employee Name cannot be empty!")
    @Column(name = "ename")
    private String ename;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 1000000, message = "Salary cannot exceed 10,00,000")
    @Column(name = "salary")
    private float salary;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_mobiles", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "mobile")
    private Set<
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
        String> mobileNumbers;

    @NotNull(message = "Department cannot be null")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee() {}

    public int getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + ", mobileNumbers=" + mobileNumbers
				+ ", department=" + department + "]";
	}
    
}