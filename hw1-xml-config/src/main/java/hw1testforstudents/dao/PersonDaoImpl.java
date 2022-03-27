package hw1testforstudents.dao;

import hw1testforstudents.domain.Person;

public class PersonDaoImpl implements PersonDao {

      public Person findByName(String name, String surname) {

          return new Person(name, surname);
    }
}
