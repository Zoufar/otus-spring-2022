package ru.otus.hw4springbootinitquiz.domain;

import lombok.Getter;
import ru.otus.hw4springbootinitquiz.model.Quiz;

import java.util.List;

@Getter
public class Person {

    private final String name;
    private final String surname;
    private final Quiz quiz;

    public Person (String name, String surname, Quiz quiz){
        this.name = name;
        this.surname = surname;
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "name+surname = " + this.name+" "+ this.surname;
    }
}
