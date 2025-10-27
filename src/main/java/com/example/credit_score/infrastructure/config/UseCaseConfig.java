package com.example.credit_score.infrastructure.config;

import com.example.credit_score.application.usecase.EvaluateCreditService;
import com.example.credit_score.domain.port.in.EvaluateCreditUseCase;
import com.example.credit_score.domain.port.out.CreditEvaluationRepository;
import com.example.credit_score.domain.port.out.CreditScorePublisher;
import com.example.credit_score.domain.service.CreditScoringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public EvaluateCreditUseCase evaluateCreditUseCase(CreditEvaluationRepository repository,
                                                       CreditScorePublisher publisher) {
        return new EvaluateCreditService(
                new CreditScoringService(),
                repository,
                publisher
        );
    }
}
