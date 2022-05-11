package ru.otus.hw4springbootinitquiz.exceptions;

public class QuizLoadingException extends RuntimeException{
    public QuizLoadingException (String message) {
        super(message);
    }
}
