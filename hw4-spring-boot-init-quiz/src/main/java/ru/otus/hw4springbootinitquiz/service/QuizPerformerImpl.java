package ru.otus.hw4springbootinitquiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizPerformerImpl implements QuizPerformer {

    private final IOService ioService;
    private final QuizMessageSource msg;

    public List<String> performQuiz(Person person) {
        ioService.outputString(msg.getMessage("string.quiz", person.getName(),
                person.getSurname()));
        List<String> result = new ArrayList<>();

        for (List list : person.getQuiz().getQuizList()) {
            askQuestionFromList(list);
            result.add(receiveAnswer(person.getQuiz().getQuizValidAnswersSet()));
        }
        return result;
    }

    private void askQuestionFromList(List<String> list) {
        for (int i = 2; i < list.size(); i++) {
            ioService.outputString(list.get(i));
        }
    }

    private String receiveAnswer(List<String> validEntries) {
        String[] arrayValidEntries = validEntries.toArray(new String[0]);
        return ioService.readStringWithPromptAndValues(msg.getMessage("string.enterchoice"),
                arrayValidEntries);
    }

}
