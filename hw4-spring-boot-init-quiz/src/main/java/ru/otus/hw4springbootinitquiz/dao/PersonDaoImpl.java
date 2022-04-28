package ru.otus.hw4springbootinitquiz.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.model.Quiz;
import ru.otus.hw4springbootinitquiz.service.QuizLoader;

@RequiredArgsConstructor
@Component
public class PersonDaoImpl implements PersonDao {

    private final QuizLoader quizLoader;

    public Person findByName(String name, String surname) {
        return new Person(name, surname, new Quiz(quizLoader));
    }
}
