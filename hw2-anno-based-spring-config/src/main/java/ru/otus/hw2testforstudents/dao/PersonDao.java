package ru.otus.hw2testforstudents.dao;

import ru.otus.hw2testforstudents.domain.Person;

public interface PersonDao {

    Person findByName(String name, String surname);
}
