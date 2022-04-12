package hw1testforstudents.service;

import hw1testforstudents.domain.Person;

public interface PersonService {
    Person enterPersonByName();

    Person getByName(String name, String surname);
}
