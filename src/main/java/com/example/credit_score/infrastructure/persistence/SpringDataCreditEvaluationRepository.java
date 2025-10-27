package com.example.credit_score.infrastructure.persistence;

import com.example.credit_score.domain.model.CreditEvaluation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCreditEvaluationRepository extends MongoRepository<CreditEvaluation, String> {
}
