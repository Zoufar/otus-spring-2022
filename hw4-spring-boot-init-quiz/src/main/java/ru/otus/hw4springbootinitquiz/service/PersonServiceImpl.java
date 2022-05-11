package ru.otus.hw4springbootinitquiz.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4springbootinitquiz.dao.PersonDao;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.model.Quiz;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;
    private final QuizLoader quizLoader;
    private final IOService ioService;
    private final QuizMessageSource msg;

    @Override
    public Person enterPersonByName() {

        String name = ioService.readStringWithPrompt(msg.getMessage("string.introname"));
        String surname = ioService.readStringWithPrompt(msg.getMessage("string.introsurname"));
        return new Person(name, surname, new Quiz(quizLoader));
    }

    @Override
    public Person getByName(String name, String surname) {
        return dao.findByName(name, surname);
    }

}
