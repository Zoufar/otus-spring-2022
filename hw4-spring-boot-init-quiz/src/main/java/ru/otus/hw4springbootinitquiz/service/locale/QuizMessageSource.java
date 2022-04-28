package ru.otus.hw4springbootinitquiz.service.locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.hw4springbootinitquiz.config.AppsProps;

import java.util.Locale;

@Component
public class QuizMessageSource {

    @Autowired
    private MessageSource messageSource;
    private final AppsProps appsProps;
    private String languageTag;


    public QuizMessageSource(AppsProps appsProps) {
        this.appsProps = appsProps;
    }

    public String getMessage(String messageKey, String... entries) {
        Locale locale = Locale.forLanguageTag(languageTag);
        String message = messageSource.getMessage(messageKey, entries, locale);
        return message;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
        System.out.println(getMessage("string.languageset"));
    }

    public String getLanguageTag() {
        return languageTag;
    }

}
