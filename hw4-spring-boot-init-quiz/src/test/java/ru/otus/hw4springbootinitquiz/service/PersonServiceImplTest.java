package ru.otus.hw4springbootinitquiz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.dao.PersonDao;
import ru.otus.hw4springbootinitquiz.dao.PersonDaoImpl;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PersonServiceImplTest {

    @DisplayName("Test of introducing procedure")
    @Test
    void shouldCorrectlyEnterPersonByName() {

        QuizMessageSource messageSource = mock(QuizMessageSource.class);
        AppsProps appsProps = mock(AppsProps.class);
        given(appsProps.getLocaleFileNameCsv()).willReturn("testQuestions.csv");
        given(messageSource.getMessage(any())).willReturn("inquiry>");
        QuizLoader quizLoader = new QuizCSVLoader(appsProps);
        PersonDao personDao = new PersonDaoImpl(quizLoader);

        InputStream stdin = System.in;
        String data = "Hello\nWorld\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        IOService ioService = new IOServiceStreams(System.out, System.in);
        PersonService service = new PersonServiceImpl(personDao, quizLoader, ioService, messageSource);

            Person testStudent = service.enterPersonByName();

            assertEquals("Hello", testStudent.getName());
            assertEquals("World", testStudent.getSurname());

         System.setIn(stdin);
    }
}