package ru.otus.hw4springbootinitquiz.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "application")
@Component
public class AppsProps {

    private String fileNameCsv;
    private int passThreshold;
    private String localeFileNameCsv;

    public void setLocaleFileNameCsv(String languageTag) {
        localeFileNameCsv = fileNameCsv;
        if (!languageTag.equals(""))
            this.localeFileNameCsv = fileNameCsv.replace(".",
                    "_" + languageTag.replace("-", "_") + ".");
    }

}

