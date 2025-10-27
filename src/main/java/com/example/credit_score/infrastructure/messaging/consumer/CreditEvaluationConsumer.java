package com.example.credit_score.infrastructure.messaging.consumer;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.in.EvaluateCreditUseCase;
import com.example.credit_score.infrastructure.config.RabbitMQConfig;
import com.example.credit_score.infrastructure.messaging.dto.CreditEvaluationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CreditEvaluationConsumer {

    private final EvaluateCreditUseCase evaluateCreditUseCase;

    public CreditEvaluationConsumer(EvaluateCreditUseCase evaluateCreditUseCase) {
        this.evaluateCreditUseCase = evaluateCreditUseCase;
    }

    @RabbitListener(queues = RabbitMQConfig.REQUEST_QUEUE)
    public void receive(CreditEvaluationMessage message) {
        CreditEvaluation evaluation = evaluateCreditUseCase.evaluate(
                message.getApplicantId(),
                message.getAge(),
                message.getIncome(),
                message.getCreditHistoryScore()
        );

        System.out.println("Evaluación procesada desde RabbitMQ: " + evaluation);
        // Aquí se guarda automáticamente en MongoDB si el caso de uso lo hace
    }
}
