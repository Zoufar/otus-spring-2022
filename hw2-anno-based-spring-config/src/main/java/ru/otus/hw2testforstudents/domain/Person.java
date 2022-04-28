package ru.otus.hw2testforstudents.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.otus.hw2testforstudents.model.Quiz;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Person {

    private final String name;
    private final String surname;
    private final Quiz quiz;

    public void enterQuizResult (List<String> result ){
        quiz.enterResults(result);
    }

    public int evaluateQuizResult (){
        return quiz.evaluateQuizResult ();
    }

    @Override
    public String toString() {
        return "name+surname = " + this.name+" "+ this.surname;
    }
}
