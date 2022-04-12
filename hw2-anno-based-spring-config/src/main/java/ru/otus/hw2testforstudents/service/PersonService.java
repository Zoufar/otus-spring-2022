package ru.otus.hw2testforstudents.service;

import ru.otus.hw2testforstudents.domain.Person;

public interface PersonService {

    Person enterPersonByName ();

    Person getByName(String name, String surname);
}
