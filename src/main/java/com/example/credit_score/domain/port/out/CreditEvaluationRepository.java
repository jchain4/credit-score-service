package com.example.credit_score.domain.port.out;

import com.example.credit_score.domain.model.CreditEvaluation;
import java.util.Optional;

public interface CreditEvaluationRepository {
    CreditEvaluation save(CreditEvaluation evaluation);
    Optional<CreditEvaluation> findById(String id);
}

