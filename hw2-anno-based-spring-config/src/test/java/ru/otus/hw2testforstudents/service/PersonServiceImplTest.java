package ru.otus.hw2testforstudents.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.dao.PersonDao;
import ru.otus.hw2testforstudents.dao.PersonDaoImpl;
import ru.otus.hw2testforstudents.domain.Person;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test of introducing procedure")
    @Test
    void shouldCorrectlyEnterPersonByName() {

        QuizConfig quizConfig = mock(QuizConfig.class);
        given(quizConfig.getFileNameCSV()).willReturn("testQuestions.csv");
         QuizLoader quizLoader = new QuizCSVLoader(quizConfig);
        PersonDao testDao = new PersonDaoImpl(quizLoader);

        InputStream stdin = System.in;
        String data = "Hello\nWorld\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        IOService ioService = new IOServiceStreams(System.out, System.in);
        PersonService service = new PersonServiceImpl(testDao, quizLoader, ioService);

            Person testStudent = service.enterPersonByName();

            assertEquals("Hello", testStudent.getName());
            assertEquals("World", testStudent.getSurname());

         System.setIn(stdin);
    }
}