package com.example.credit_score.application.usecase;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.in.EvaluateCreditUseCase;
import com.example.credit_score.domain.port.out.CreditEvaluationRepository;
import com.example.credit_score.domain.port.out.CreditScorePublisher;
import com.example.credit_score.domain.service.CreditScoringService;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.*;
import java.util.UUID;

public class EvaluateCreditService implements EvaluateCreditUseCase {

    private final CreditScoringService scoringService;
    private final CreditEvaluationRepository repository;
    private final CreditScorePublisher publisher;

    public EvaluateCreditService(CreditScoringService scoringService,
                                 CreditEvaluationRepository repository,
                                 @Qualifier("rabbitMQCreditScorePublisher") CreditScorePublisher publisher)  {
        this.scoringService = scoringService;
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public CreditEvaluation evaluate(String applicantId, int age, double income, int historyScore) {
        int score = scoringService.calculateScore(age, income, historyScore);

        CreditEvaluation evaluation = new CreditEvaluation();
        evaluation.setId(UUID.randomUUID().toString());
        evaluation.setApplicantId(applicantId);
        evaluation.setAge(age);
        evaluation.setIncome(income);
        evaluation.setCreditHistoryScore(historyScore);
        evaluation.setCreditScore(score);
        evaluation.setEvaluatedAt(LocalDateTime.now());

        repository.save(evaluation);
        publisher.publish(evaluation);

        return evaluation;
    }
}
