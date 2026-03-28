package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String applicantName;
    private double loanAmount;
    private String status;
    
    public Loan(String status) {}
    public Loan() {}

    public Loan(String applicantName, double loanAmount, String status) {
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.status = status;
    }

	public Integer getId() {
		return id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}