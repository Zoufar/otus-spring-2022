package ru.otus.hw4springbootinitquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class IOServiceStreams implements IOService {
    private final PrintStream output;
    private final Scanner input;
    @Autowired
    private QuizMessageSource msg;

    public IOServiceStreams(PrintStream outputStream, InputStream inputStream) {
        output = outputStream;
        input = new Scanner(inputStream, "Cp866");
    }

    @Override
    public void outputString(String s) {
        output.println(s);
    }

    @Override
    public String readStringWithPromptAndValues(String prompt, String... validValues) {
        String inputString = readStringWithPrompt(prompt);
        if (validValues.length == 0) return inputString;

        List<String> validValuesList = Arrays.asList(validValues);

        while (!validValuesList.contains(inputString)) {
            inputString = readStringWithPrompt(msg.getMessage("string.notvalidentry") +
                    validValuesList + ".\n" + msg.getMessage("string.tryoncemore"));
        }
        return inputString;
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        outputString(prompt);
        return input.nextLine();
    }
}
