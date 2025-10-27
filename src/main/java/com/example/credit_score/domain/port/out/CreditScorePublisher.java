package com.example.credit_score.domain.port.out;

import com.example.credit_score.domain.model.CreditEvaluation;

public interface CreditScorePublisher {
    void publish(CreditEvaluation evaluation);
}