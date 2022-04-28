package ru.otus.hw2testforstudents.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.service.QuizCSVLoader;
import ru.otus.hw2testforstudents.service.QuizLoader;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PersonDaoImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test of request of Person from Dao")
    @Test
    void findByNameShallReturnProperName() {
        QuizConfig quizConfig = mock(QuizConfig.class);
        given(quizConfig.getFileNameCSV()).willReturn("testQuestions.csv");
        QuizLoader quizLoader = new QuizCSVLoader(quizConfig);
        PersonDao personDao = new PersonDaoImpl(quizLoader);

        Person person = personDao.findByName("Pierre", "Bezuhoff");

        assertEquals("Pierre", person.getName());
        assertEquals("Bezuhoff", person.getSurname());

    }
}