package ru.otus.hw4springbootinitquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.hw4springbootinitquiz.config.AppsProps;
import ru.otus.hw4springbootinitquiz.quiz.StudentQuizImpl;


@SpringBootApplication
@EnableConfigurationProperties(AppsProps.class)
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		ctx.getBean(StudentQuizImpl.class).start();

		((ConfigurableApplicationContext) ctx).close();

	}

}
