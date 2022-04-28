package ru.otus.hw4springbootinitquiz.dao;

import ru.otus.hw4springbootinitquiz.domain.Person;

public interface PersonDao {

    Person findByName(String name, String surname);
}
