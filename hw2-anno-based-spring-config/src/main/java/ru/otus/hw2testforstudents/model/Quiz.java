package ru.otus.hw2testforstudents.model;

import lombok.Getter;
import ru.otus.hw2testforstudents.service.QuizLoader;

import java.util.List;

@Getter
public class Quiz {
    private final List<List<String>> quizList;
    private final QuizLoader quizLoader;

    public Quiz(QuizLoader quizLoader) {
        this.quizLoader = quizLoader;
        quizList = this.quizLoader.loadQuiz();
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



