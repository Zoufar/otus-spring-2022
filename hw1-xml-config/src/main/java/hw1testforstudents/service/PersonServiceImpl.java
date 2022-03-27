package hw1testforstudents.service;

import hw1testforstudents.dao.PersonDao;
import hw1testforstudents.domain.Person;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person enterPersonByName () {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your name>");
            String name = scanner.nextLine();
            System.out.println("Please enter your surname>");
            String surname = scanner.nextLine();
            return new Person(name, surname);
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public Person getByName(String name, String surname) {
        return dao.findByName(name, surname);
    }
}
