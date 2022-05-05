package ru.otus.hw4springbootinitquiz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.model.Quiz;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class QuizResultEvaluatorImplTest {

    @DisplayName("shall return proper evaluation of quiz results")
    @Test
    void shallEvaluateQuizResultProperly() {

        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        Quiz quiz = new Quiz(quizLoader);
        QuizResultEvaluator quizResultEvaluator = new QuizResultEvaluatorImpl();
        List<String> resultList = List.of("A", "B", "C", "A", "B");

        for (int i = 0; i < resultList.size() && i < quiz.getQuizList().size(); i++){
            quiz.getQuizList().get(i).set(0, resultList.get(i));
        }

        int expectedEvaluation = 3;

        assertEquals(expectedEvaluation, quizResultEvaluator.evaluateQuizResult(quiz));

    }
}