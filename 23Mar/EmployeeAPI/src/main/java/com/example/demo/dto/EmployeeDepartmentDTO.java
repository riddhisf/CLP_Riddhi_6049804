package com.example.demo.dto;

public class EmployeeDepartmentDTO {

    private int id;
    private String ename;
    private String dname;
    private String managerName;

    public EmployeeDepartmentDTO(int id, String ename, String dname, String managerName) {
        this.id = id;
        this.ename = ename;
        this.dname = dname;
        this.managerName = managerName;
    }

	@Override
	public String toString() {
		return "EmployeeDepartmentDTO [id=" + id + ", ename=" + ename + ", dname=" + dname + ", managerName="
				+ managerName + "]";
	}

	public int getId() {
		return id;
	}

	public String getEname() {
		return ename;
	}

	public String getDname() {
		return dname;
	}

	public String getManagerName() {
		return managerName;
	}
    
}