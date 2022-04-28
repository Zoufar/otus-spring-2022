package ru.otus.hw4springbootinitquiz.service;


public interface IOService {

    String readStringWithPrompt(String prompt);

    String readStringWithPromptAndValues(String prompt, String... validValues);

    void outputString(String s);

}
