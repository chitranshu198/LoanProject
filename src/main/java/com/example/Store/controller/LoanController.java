package com.example.Store.controller;

import com.example.Store.entity.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

    private LoanService loanService;

    //constructor based dependency injection
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<String> saveLoan(@RequestBody Loan loan){

        loanService.saveLoan(loan);

        return ResponseEntity.ok("Loan successfully saved ");
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> loans=loanService.getAllLoans();

        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}
