package ru.otus.hw2testforstudents.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import ru.otus.hw2testforstudents.config.QuizConfig;
import ru.otus.hw2testforstudents.exceptions.QuizLoadingException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizCSVLoader implements QuizLoader {

    private final QuizConfig quizConfig;

    public QuizCSVLoader(QuizConfig quizConfig) {
        this.quizConfig = quizConfig;
    }

    public List loadQuiz() {
        List<List<String>> quizList = new ArrayList<>();
        InputStream inputStreamfromCSVfile =
                getClass().getClassLoader().getResourceAsStream(quizConfig.getFileNameCSV());

        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStreamfromCSVfile))) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                quizList.add(Arrays.asList(lineInArray));
            }
        } catch (IOException io) {
            throw new QuizLoadingException("QuizLoader IO Exception");
        } catch (CsvException csv) {
            throw new QuizLoadingException("QuizLoader CSV Exception");
        }

        checkQuizListIntegrity();

        return quizList;
    }

    void checkQuizListIntegrity(){};
}
