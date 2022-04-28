package ru.otus.hw2testforstudents.service;

import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizPerformerImpl implements QuizPerformer {

    private final IOService ioService;

    public QuizPerformerImpl(IOService ioService) {
        this.ioService = ioService;
    }

    public List<String> performQuiz(Person person) {
        ioService.outputString("Hi " + person.getName() + " " + person.getSurname()
                + ", please answer following questions: ");
        List<String> result = new ArrayList<>();

        for (List list : person.getQuiz().getQuizList()) {
            askQuestionFromList(list);
            result.add(receiveAnswer());
        }
        return result;
    }

    private void askQuestionFromList(List<String> list) {
        for (int i = 2; i < list.size(); i++) {
            ioService.outputString(list.get(i));
        }
    }

    private String receiveAnswer() {
        return ioService.readStringWithPromptAndValues("Please enter your choice: ",
                "A", "B", "C", "D", "E");
    }

}
