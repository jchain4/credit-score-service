package com.example.credit_score.infrastructure.messaging.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreditEvaluationMessage {
    private String applicantId;
    private int age;
    private double income;
    private int creditHistoryScore;
    private int creditScore; // nuevo
    private LocalDateTime evaluatedAt; // nuevo
}

