package ru.rsreu.Babaian.ElectronicStore;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.rsreu.Babaian.ElectronicStore.model.Question;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;

@SpringBootApplication
public class ChineseCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChineseCourseApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(IQuestionRepository repo) {
		return args -> {
			repo.save(new Question(1L, "How do you say \"hello\" in Chinese?", "你好"));
			repo.save(new Question(2L, "How do you say \"goodbye\" in Chinese?", "再见"));
		};
	}
}
