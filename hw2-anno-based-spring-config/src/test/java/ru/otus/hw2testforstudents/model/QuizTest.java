package ru.otus.hw2testforstudents.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.service.QuizCSVLoader;
import ru.otus.hw2testforstudents.service.QuizLoader;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class QuizTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("shall return the same results as entered")
    @Test
    void shallReturnProperResults() {
        QuizConfig quizConfig = mock(QuizConfig.class);
        given(quizConfig.getFileNameCSV()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(quizConfig);
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
        QuizConfig quizConfig = mock(QuizConfig.class);
        given(quizConfig.getFileNameCSV()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(quizConfig);
        Quiz quiz = new Quiz(quizLoader);
        List<String> resultList = asList("A", "B", "C", "A", "B");

        quiz.enterResults(resultList);

        int expectedEvaluation = 3;

        assertEquals(expectedEvaluation, quiz.evaluateQuizResult());

    }
}