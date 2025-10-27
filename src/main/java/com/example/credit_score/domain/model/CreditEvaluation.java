package com.example.credit_score.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Document
@Data
public class CreditEvaluation {
    @Id
    private String id;
    private String applicantId;
    private int age;
    private double income;
    private int creditHistoryScore;
    private int creditScore;
    private LocalDateTime evaluatedAt;

}
