package com.example.Store.repository;

import com.example.Store.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,String> {
}
