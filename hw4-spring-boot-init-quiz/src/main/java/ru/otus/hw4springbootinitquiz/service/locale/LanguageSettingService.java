package ru.otus.hw4springbootinitquiz.service.locale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.service.IOService;

@RequiredArgsConstructor
@Component
public class LanguageSettingService {

    private final AppsProps appsProps;
    private final IOService ioService;
    private final QuizMessageSource quizMessageSource;

    private String languageTag= "";

    public void receiveAndSetLocaleLanguage() {
       String key = ioService.readStringWithPrompt("\nDefault Language is English.\n" +
                "Please enter any symbol to switch to Russian\n" +
                "or press ENTER to continue:\n\n" +
                "Язык по умолчанию английский.\n" +
                "Чтобы переключиться на русский, введите любой символ;\n" +
                "или нажмите ENTER чтобы продолжить:"
        );

        if(key.length()!=0) languageTag = "ru-RU";

        quizMessageSource.setLanguageTag(languageTag);
        appsProps.setLocaleFileNameCsv(languageTag);
        languageTag= "";
    }
}
