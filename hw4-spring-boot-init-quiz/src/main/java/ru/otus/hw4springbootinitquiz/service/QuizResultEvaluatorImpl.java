package ru.otus.hw4springbootinitquiz.service;

import org.springframework.stereotype.Service;
import ru.otus.hw4springbootinitquiz.model.Quiz;

@Service
public class QuizResultEvaluatorImpl implements QuizResultEvaluator {

    @Override
    public int evaluateQuizResult(Quiz quiz) {
        return (int) quiz.getQuizList().stream().
                filter(line -> line.get(0).equalsIgnoreCase(line.get(1))).
                count();
    }
}
