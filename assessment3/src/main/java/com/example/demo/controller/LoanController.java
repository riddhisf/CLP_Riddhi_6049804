
package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanServiceImpl service;

    @PostMapping
    public Loan createLoan(@Valid @RequestBody Loan loan) {
        return service.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable Integer id) {
        return service.getLoanById(id);
    }

    @PutMapping("/{id}/status")
    public Loan updateLoanStatus(@PathVariable Integer id,@RequestBody Loan loan) {
        return service.updateLoanStatus(id, loan.getStatus());
    }
}