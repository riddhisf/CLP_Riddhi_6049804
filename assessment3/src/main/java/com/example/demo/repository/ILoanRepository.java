package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Loan;

public interface ILoanRepository extends JpaRepository<Loan, Integer>{

	Optional<Loan> findByApplicantNameAndStatus(String applicantName, String string);

}
