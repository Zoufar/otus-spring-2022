package ru.otus.hw4springbootinitquiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw4springbootinitquiz.service.IOService;
import ru.otus.hw4springbootinitquiz.service.IOServiceStreams;


@Configuration
public class QuizConfig {

    @Bean
    IOService ioService () { return new IOServiceStreams(System.out, System.in);}

    }

