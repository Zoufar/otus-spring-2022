package ru.otus.hw2testforstudents.service;


public interface IOService {

    String readStringWithPrompt(String prompt);

    String readStringWithPromptAndValues (String prompt, String... validValues);

    void outputString(String s);

}
