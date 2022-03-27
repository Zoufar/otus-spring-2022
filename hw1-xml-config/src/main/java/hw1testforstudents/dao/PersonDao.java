package hw1testforstudents.dao;

import hw1testforstudents.domain.Person;

public interface PersonDao {

    Person findByName(String name, String surname);
}
