package ru.otus.hw4springbootinitquiz.service;

import ru.otus.hw4springbootinitquiz.domain.Person;

public interface PersonService {

    Person enterPersonByName();

    Person getByName(String name, String surname);
}
