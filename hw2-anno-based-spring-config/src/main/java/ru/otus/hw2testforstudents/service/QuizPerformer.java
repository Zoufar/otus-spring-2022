package ru.otus.hw2testforstudents.service;

import ru.otus.hw2testforstudents.domain.Person;

import java.util.List;

public interface QuizPerformer {
    List<String> performQuiz (Person person);
}
