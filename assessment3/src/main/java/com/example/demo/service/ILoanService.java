package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Loan;

@Service
public interface ILoanService {	
	Loan createLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoanById(Integer id);
    Loan updateLoanStatus(Integer id, String status);
}

