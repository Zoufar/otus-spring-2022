package ru.otus.hw4springbootinitquiz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.model.Quiz;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class QuizPerformerImplTest {

    @DisplayName("shall return the same results as entered")
    @Test
    void performQuizShouldReturnProperResults() {
        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        QuizMessageSource msg = mock(QuizMessageSource.class);
        given(msg.getMessage(any())).willReturn("mock");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        Quiz quiz = new Quiz(quizLoader);
        Person person = new Person("A", "B", quiz);

        List<String> resultList = List.of("A", "B", "C", "A", "B");

        InputStream stdin = System.in;
        String data = "A\nB\nC\nA\nB\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        IOService ioService = new IOServiceStreams(System.out, System.in);

        QuizPerformer quizPerformer = new QuizPerformerImpl(ioService, msg);

        quizPerformer.performQuiz( person);

        List<String> returnedResults = new ArrayList<>();
        for (List line : quiz.getQuizList()) {
            returnedResults.add((String) line.get(0));
        }
        assertEquals(resultList, returnedResults);

        System.setIn(stdin);
    }
}