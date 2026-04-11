package cg.demo.jpahibernate.entities;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private int id;

    @Column(name = "ename")
    private String ename;

    @Column(name = "salary")
    private float salary;
    
    @Column(name = "dept")
    private String dept;

    @ElementCollection
    @CollectionTable(name="employee_mobiles",
            joinColumns=@JoinColumn(name="emp_id"))
    @Column(name="mobile")
    private Set<String> mobileNumbers;

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setId(int id) {
		this.id = id;
	}
    

}