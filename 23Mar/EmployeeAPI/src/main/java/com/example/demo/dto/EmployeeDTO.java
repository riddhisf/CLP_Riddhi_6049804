package com.example.demo.dto;

import java.util.Set;

public class EmployeeDTO {

    private int id;
    private String ename;
    private float salary;
    private String deptName;
    private Set<String> mobile;
    
    public EmployeeDTO(int id, String ename, float salary, String deptName) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
        this.deptName = deptName;
    }

    public EmployeeDTO(int id, String ename, float salary, String deptName, Set<String> mobile) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
        this.deptName = deptName;
        this.mobile= mobile;
    }

    public int getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public float getSalary() {
        return salary;
    }

    public String getDeptName() {
        return deptName;
    }

	public Set<String> getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		if(mobile!=null)
			return "EmployeeDTO [id=" + id + ", ename=" + ename + ", salary=" + salary + ", deptName=" + deptName
				+ ", mobile=" + mobile + "]";
		else
			return "EmployeeDTO [id=" + id + ", ename=" + ename + ", salary=" + salary + ", deptName=" + deptName
					+ "]";
	}
	
    
}