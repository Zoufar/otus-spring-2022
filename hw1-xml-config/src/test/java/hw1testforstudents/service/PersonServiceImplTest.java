package hw1testforstudents.service;

import hw1testforstudents.dao.PersonDao;
import hw1testforstudents.dao.PersonDaoImpl;
import hw1testforstudents.domain.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceImplTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void shouldCorrectlyEnterPersonByName() {
        PersonDao testDao = new PersonDaoImpl();
        PersonService testService = new PersonServiceImpl(testDao);
        String data = "Hello\nWorld\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        try {
            Person testStudent = testService.enterPersonByName();
            System.out.println(testStudent);

            assertEquals("Hello", testStudent.getName());
            assertEquals("World", testStudent.getSurname());
        } finally {
            System.setIn(stdin);
        }
    }
}