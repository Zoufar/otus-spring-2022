package ru.otus.hw4springbootinitquiz.model;

import lombok.Getter;
import ru.otus.hw4springbootinitquiz.service.QuizLoader;

import java.util.List;

@Getter
public class Quiz {
    private final List<List<String>> quizList;
    private final List<String> quizValidAnswersSet;

    public Quiz(QuizLoader quizLoader) {
        quizList = quizLoader.loadQuiz();
        quizValidAnswersSet = quizList.remove(0);
    }

    @Override
    public String toString() {
        return quizList.toString();
    }
}



