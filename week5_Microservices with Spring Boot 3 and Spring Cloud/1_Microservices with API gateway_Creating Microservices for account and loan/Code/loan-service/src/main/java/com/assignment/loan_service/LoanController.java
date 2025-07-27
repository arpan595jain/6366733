package com.assignment.loan_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loan/loan")
    public String getLoanInfo() {
        return "Hello from Loan Service!";
    }
}
