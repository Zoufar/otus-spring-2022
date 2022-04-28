package ru.otus.hw4springbootinitquiz.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.service.QuizCSVLoader;
import ru.otus.hw4springbootinitquiz.service.QuizLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PersonDaoImplTest {

    @DisplayName("Test of request of Person from Dao")
    @Test
    void findByNameShallReturnProperName() {
        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        PersonDao personDao = new PersonDaoImpl(quizLoader);

        Person person = personDao.findByName("Pierre", "Bezuhoff");

        assertEquals("Pierre", person.getName());
        assertEquals("Bezuhoff", person.getSurname());

    }
}