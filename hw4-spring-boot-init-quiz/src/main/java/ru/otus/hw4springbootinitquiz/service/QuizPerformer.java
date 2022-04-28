package ru.otus.hw4springbootinitquiz.service;

import ru.otus.hw4springbootinitquiz.domain.Person;

import java.util.List;

public interface QuizPerformer {
    List<String> performQuiz(Person person);
}
