package ru.otus.hw4springbootinitquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.hw4springbootinitquiz.service.locale.QuizMessageSource;

import java.io.InputStream;
import java.io.PrintStream;
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
    public String readStringWithPrompt(String prompt) {
        outputString(prompt);
        return input.nextLine();
    }
}
