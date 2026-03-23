package com.example.demo.dto;

public class DepartmentCountDTO {

    private String dname;
    private long count;

    public DepartmentCountDTO(String dname, long count) {
        this.dname = dname;
        this.count = count;
    }

	@Override
	public String toString() {
		return "DepartmentCountDTO [dname=" + dname + ", count=" + count + "]";
	}

	public String getDname() {
		return dname;
	}

	public long getCount() {
		return count;
	}
	
	
    
}