package ru.otus.hw2testforstudents.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.hw2testforstudents.service.IOService;
import ru.otus.hw2testforstudents.service.IOServiceStreams;

@Getter
@Configuration
@PropertySource("application.properties")
public class QuizConfig {

    @Value("${fileNameCSV}")
    private String fileNameCSV;

    @Value("${passThreshold}")
    private int passThreshold;

    @Bean
    IOService ioService () { return new IOServiceStreams(System.out, System.in);}

    }

