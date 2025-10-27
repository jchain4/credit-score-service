package com.example.credit_score.infrastructure.web;

import com.example.credit_score.domain.model.CreditEvaluation;
import com.example.credit_score.domain.port.in.EvaluateCreditUseCase;
import com.example.credit_score.infrastructure.web.dto.CreditEvaluationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation")
public class CreditEvaluationController {

    private final EvaluateCreditUseCase evaluateCreditUseCase;

    public CreditEvaluationController(EvaluateCreditUseCase evaluateCreditUseCase) {
        this.evaluateCreditUseCase = evaluateCreditUseCase;
    }

    @PostMapping
    public ResponseEntity<CreditEvaluation> evaluate(@RequestBody CreditEvaluationRequest request) {
        CreditEvaluation result = evaluateCreditUseCase.evaluate(
                request.getApplicantId(),
                request.getAge(),
                request.getIncome(),
                request.getCreditHistoryScore()
        );
        return ResponseEntity.ok(result);
    }
}
