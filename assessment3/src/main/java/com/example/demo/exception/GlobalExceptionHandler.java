package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLoanNotFound(LoanNotFoundException e) {
        ErrorResponse error = new ErrorResponse(
                "LoanNotFoundException",
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DuplicateLoanApplicationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateLoan(DuplicateLoanApplicationException e) {
        ErrorResponse error = new ErrorResponse(
                "DuplicateLoanApplicationException",
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidLoanAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLoanAmount(InvalidLoanAmountException e) {
        ErrorResponse error = new ErrorResponse(
                "InvalidLoanAmountException",
                e.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fe : fieldErrors) {
            errors.put(fe.getField(), fe.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}