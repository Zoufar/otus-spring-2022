package ru.otus.hw4springbootinitquiz.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.service.IOService;
import ru.otus.hw4springbootinitquiz.service.PersonService;
import ru.otus.hw4springbootinitquiz.service.QuizPerformer;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentQuizImpl implements StudentQuiz {

    private final PersonService studentService;
    private final AppsProps appsProps;
    private final IOService ioService;
    private final QuizPerformer quizPerformer;
    private final QuizMessageSource msg;

    @Override
    public boolean start() {

        int passThreshold = appsProps.getPassThreshold();

        ioService.outputString(msg.getMessage("string.start")+"\n"
                + msg.getMessage("string.threshhold")
                + passThreshold + ".");
        Person student = studentService.enterPersonByName();

        List<String> result = quizPerformer.performQuiz(student);
        student.enterQuizResult(result);

        int resultEvaluated = student.evaluateQuizResult();
        String isThresholdPassed = resultEvaluated < passThreshold?
                msg.getMessage("string.notpassed") :
                msg.getMessage("string.passed");
        ioService.outputString(msg.getMessage("string.result") +
                resultEvaluated+".\n" + isThresholdPassed);

        String turnKey = ioService.readStringWithPrompt("\n"+msg.getMessage("string.continue"));

        return turnKey.length()!=0;

    }

}
