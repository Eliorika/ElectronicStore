package ru.rsreu.Babaian.ElectronicStore;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.Babaian.ElectronicStore.model.Question;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;
import ru.rsreu.Babaian.ElectronicStore.repo.IUserRepo;

@SpringBootApplication
@AllArgsConstructor
public class ChineseCourseApplication {

	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ChineseCourseApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(IQuestionRepository questionRepo, IUserRepo userRepo) {
		return args -> {
			questionRepo.save(new Question(1L, "How do you say \"hello\" in Chinese?", "你好"));
			questionRepo.save(new Question(2L, "How do you say \"goodbye\" in Chinese?", "再见"));
			userRepo.save(new User(1l, "admin", passwordEncoder.encode("0000")));
		};
	}
}
