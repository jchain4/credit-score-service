package com.example.credit_score.domain.service;

public class CreditScoringService {
    public int calculateScore(int age, double income, int historyScore) {
        int score = historyScore;
        score += (income > 3000) ? 20 : 10;
        score += (age > 25) ? 15 : 5;
        return Math.min(score, 100);
    }
}
