package com.example.credit_score.infrastructure.web.dto;

import lombok.Data;

@Data
public class CreditEvaluationRequest {
    private String applicantId;
    private int age;
    private double income;
    private int creditHistoryScore;
}
