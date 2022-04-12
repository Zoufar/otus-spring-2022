package ru.otus.hw2testforstudents.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.model.Quiz;
import ru.otus.hw2testforstudents.service.QuizLoader;

@RequiredArgsConstructor
@Repository
public class PersonDaoImpl implements PersonDao {

    private final QuizLoader quizLoader;

    public Person findByName(String name, String surname) {
        return new Person(name, surname, new Quiz(quizLoader));
    }
}
