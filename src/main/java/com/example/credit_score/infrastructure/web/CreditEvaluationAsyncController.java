package com.example.credit_score.infrastructure.web;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.in.EvaluateCreditUseCase;
import com.example.credit_score.infrastructure.config.RabbitMQConfig;
import com.example.credit_score.infrastructure.messaging.dto.CreditEvaluationMessage;
import com.example.credit_score.infrastructure.messaging.publisher.RabbitMQCreditScorePublisher;
import com.example.credit_score.infrastructure.web.dto.CreditEvaluationRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation/async")
public class CreditEvaluationAsyncController {

    private final RabbitTemplate rabbitTemplate;

    public CreditEvaluationAsyncController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<String> evaluateAsync(@RequestBody CreditEvaluationMessage message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.REQUEST_QUEUE, message);
        return ResponseEntity.accepted().body("Solicitud enviada a RabbitMQ");
    }
}

