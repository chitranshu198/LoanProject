package com.example.Store.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Loan {

    private String loanId;

    private String customerId;

    private String lenderId;

    private long amount;

    private long remainingAmount;

    private LocalDateTime paymentDate;

    private float interest;

    private LocalDateTime dueDate;

    private float penaulty;

}

