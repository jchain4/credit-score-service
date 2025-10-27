package com.example.credit_score.domain.port.in;

import com.example.credit_score.domain.model.CreditEvaluation;

public interface EvaluateCreditUseCase {
    CreditEvaluation evaluate(String applicantId, int age, double income, int historyScore);
}
