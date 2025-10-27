package com.example.credit_score.infrastructure.persistence;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.out.CreditEvaluationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoCreditEvaluationRepository implements CreditEvaluationRepository {

    private final SpringDataCreditEvaluationRepository springRepo;

    public MongoCreditEvaluationRepository(SpringDataCreditEvaluationRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public CreditEvaluation save(CreditEvaluation evaluation) {
        return springRepo.save(evaluation);
    }

    @Override
    public Optional<CreditEvaluation> findById(String id) {
        return springRepo.findById(id);
    }
}
