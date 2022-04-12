package ru.otus.hw2testforstudents.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.domain.Person;
import ru.otus.hw2testforstudents.service.IOService;
import ru.otus.hw2testforstudents.service.PersonService;
import ru.otus.hw2testforstudents.service.QuizPerformer;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentQuizImpl implements StudentQuiz {

    private final PersonService studentService;
    private final QuizConfig quizConfig;
    private final IOService ioService;
    private final QuizPerformer quizPerformer;

    @Override
    public void start() {
        int passThreshold = quizConfig.getPassThreshold();
        System.out.println("start test.\nPass threshold is " + passThreshold + ".");
        Person student = studentService.enterPersonByName();

        List<String> result = quizPerformer.performQuiz(student);
        student.enterQuizResult(result);

        int resultEvaluated = student.evaluateQuizResult();
        String isThresholdPassed = resultEvaluated < passThreshold ?
                "You haven't passed the test. Sorry." : "You've passed the test succesfully. Congratulations!";
        ioService.outputString("Your result is " + resultEvaluated + ".\n" + isThresholdPassed);
    }
}

