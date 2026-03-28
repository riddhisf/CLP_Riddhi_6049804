package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loan;
import com.example.demo.exception.DuplicateLoanApplicationException;
import com.example.demo.exception.InvalidLoanAmountException;
import com.example.demo.exception.LoanNotFoundException;
import com.example.demo.repository.ILoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements ILoanService {

    @Autowired
    private ILoanRepository repo;

    @Override
    public Loan createLoan(Loan loan) {
        if (loan.getLoanAmount()<=0||loan.getLoanAmount()>5000000) {
            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5000000");
        }
        
        Optional<Loan> existingLoan = repo.findByApplicantNameAndStatus(
                loan.getApplicantName(), "PENDING");

        if (existingLoan.isPresent()) {
            throw new DuplicateLoanApplicationException("User already has a pending loan");
        }

        loan.setStatus("PENDING");
        return repo.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return repo.findAll();
    }

    @Override
    public Loan getLoanById(Integer id) {
        Loan loan = repo.findById(id)
        		.orElseThrow(()->new LoanNotFoundException("Loan not found with id: " + id));
        return loan;
    }

    @Override
    public Loan updateLoanStatus(Integer id, String status) {

        Loan loan = repo.findById(id)
        		.orElseThrow(() -> new LoanNotFoundException("Loan not found with id: " + id));

        loan.setStatus(status);
        return repo.save(loan);
    }
}