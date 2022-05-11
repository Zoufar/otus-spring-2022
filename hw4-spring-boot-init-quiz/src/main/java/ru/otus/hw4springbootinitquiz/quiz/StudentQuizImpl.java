package ru.otus.hw4springbootinitquiz.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.domain.Person;
import ru.otus.hw4springbootinitquiz.service.IOService;
import ru.otus.hw4springbootinitquiz.service.PersonService;
import ru.otus.hw4springbootinitquiz.service.QuizPerformer;
import ru.otus.hw4springbootinitquiz.service.QuizResultEvaluatorImpl;
import ru.otus.hw4springbootinitquiz.service.locale.LanguageSettingService;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

@RequiredArgsConstructor
@Service
public class StudentQuizImpl implements StudentQuiz {

    private final LanguageSettingService languageSettingService;
    private final PersonService studentService;
    private final AppsProps appsProps;
    private final IOService ioService;
    private final QuizPerformer quizPerformer;
    private final QuizMessageSource msg;
    private final QuizResultEvaluatorImpl quizResultEvaluator;

    @Override
    public void start() {
        do {
            languageSettingService.receiveAndSetLocaleLanguage();
        }
        while (runQuiz());
    }

    @Override
    public boolean runQuiz() {
        int result = 0;
        int passThreshold = appsProps.getPassThreshold();

        ioService.outputString(msg.getMessage("string.start") + "\n"
                + msg.getMessage("string.threshhold")
                + passThreshold + ".");
        Person student = studentService.enterPersonByName();

        quizPerformer.performQuiz(student);

        result = quizResultEvaluator.evaluateQuizResult(student.getQuiz());
        String isThresholdPassed = result < passThreshold ?
                msg.getMessage("string.notpassed") :
                msg.getMessage("string.passed");
        ioService.outputString(msg.getMessage("string.result") +
                result + ".\n" + isThresholdPassed);

        String key = ioService.readStringWithPrompt("\n" + msg.getMessage("string.continue"));

        return key.length() != 0;

    }
}
