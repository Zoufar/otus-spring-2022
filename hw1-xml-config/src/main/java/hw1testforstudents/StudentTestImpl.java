package hw1testforstudents;

import hw1testforstudents.domain.Person;
import hw1testforstudents.service.PerformTesting;
import hw1testforstudents.service.PersonService;

public class StudentTestImpl implements StudentTest {

    private final PersonService studentService;
    private final PerformTesting test;

    public StudentTestImpl(PersonService studentService,PerformTesting test){
        this.studentService = studentService;
        this.test = test;
          }

    public void start() {
        System.out.println("start test");
        Person student = studentService.enterPersonByName();
        test.performTesting(student);

    }

}
