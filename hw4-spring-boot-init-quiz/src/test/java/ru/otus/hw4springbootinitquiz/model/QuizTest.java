package ru.otus.hw4springbootinitquiz.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.service.QuizCSVLoader;
import ru.otus.hw4springbootinitquiz.service.QuizLoader;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class QuizTest {

    @DisplayName("shall return the same results as entered")
    @Test
    void shallReturnProperResults() {
        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        Quiz quiz = new Quiz(quizLoader);
        List<String> resultList = asList("A", "B", "C", "A", "B");

        quiz.enterResults(resultList);

        List<String> returnedResults = new ArrayList<>();
        for (List line : quiz.getQuizList()) {
            returnedResults.add((String) line.get(0));
        }
        assertEquals(resultList, returnedResults);
    }

    @DisplayName("shall return proper evaluation of quiz results")
    @Test
    void shallEvaluateQuizResultProperly() {
        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        Quiz quiz = new Quiz(quizLoader);
        List<String> resultList = asList("A", "B", "C", "A", "B");

        quiz.enterResults(resultList);

        int expectedEvaluation = 3;

        assertEquals(expectedEvaluation, quiz.evaluateQuizResult());

    }
}