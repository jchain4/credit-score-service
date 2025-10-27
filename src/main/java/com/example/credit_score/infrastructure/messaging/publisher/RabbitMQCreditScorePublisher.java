package com.example.credit_score.infrastructure.messaging.publisher;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.out.CreditScorePublisher;
import com.example.credit_score.infrastructure.config.RabbitMQConfig;
import com.example.credit_score.infrastructure.messaging.dto.CreditEvaluationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class RabbitMQCreditScorePublisher implements CreditScorePublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQCreditScorePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(CreditEvaluation evaluation) {
        System.out.println("Publisher no dummy llamado: ");

        // Convertir el modelo de dominio al DTO
        CreditEvaluationMessage message = new CreditEvaluationMessage();
        message.setApplicantId(evaluation.getApplicantId());
        message.setAge(evaluation.getAge());
        message.setIncome(evaluation.getIncome());
        message.setCreditHistoryScore(evaluation.getCreditHistoryScore());
        message.setCreditScore(evaluation.getCreditScore());
        message.setEvaluatedAt(evaluation.getEvaluatedAt());

        rabbitTemplate.convertAndSend(RabbitMQConfig.RESULT_QUEUE, message);
    }
}

