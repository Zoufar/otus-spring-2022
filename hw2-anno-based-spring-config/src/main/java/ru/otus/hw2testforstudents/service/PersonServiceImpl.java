package ru.otus.hw2testforstudents.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.dao.PersonDao;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.model.Quiz;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;
    private final QuizLoader quizLoader;
    private final IOService ioService;

    @Override
    public Person enterPersonByName () {
            String name = ioService.readStringWithPrompt("Please enter your name>");
            String surname = ioService.readStringWithPrompt("Please enter your surname>");
           return new Person(name, surname, new Quiz(quizLoader));
    }

    @Override
    public Person getByName(String name, String surname) {
        return dao.findByName(name, surname);
    }

}
