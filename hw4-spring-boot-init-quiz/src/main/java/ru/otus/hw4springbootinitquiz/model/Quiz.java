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

    public void enterResults(List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            quizList.get(i).set(0, result.get(i));
        }
    }

    public int evaluateQuizResult() {
        return (int) quizList.stream().
                filter(line -> line.get(0).equalsIgnoreCase(line.get(1))).
                count();
    }

    @Override
    public String toString() {
        return quizList.toString();
    }
}



