package ru.otus.hw2testforstudents.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class IOServiceStreams implements IOService {
    private final PrintStream output;
    private final Scanner input;

    public IOServiceStreams(PrintStream outputStream, InputStream inputStream) {
        output = outputStream;
        input = new Scanner(inputStream);
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
            inputString = readStringWithPrompt("This is not a valid entry. Valid entries are " +
                    validValuesList + ".\n" + "Please try once more:");
        }
        return inputString;
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        outputString(prompt);
        return input.nextLine();
    }
}
