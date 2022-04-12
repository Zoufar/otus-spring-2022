package ru.otus.hw2testforstudents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.hw2testforstudents.quiz.StudentQuizImpl;

@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        context.getBean(StudentQuizImpl.class).start();
        context.close();

    }
}
