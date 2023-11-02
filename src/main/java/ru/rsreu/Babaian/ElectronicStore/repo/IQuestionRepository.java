package ru.rsreu.Babaian.ElectronicStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;
import ru.rsreu.Babaian.ElectronicStore.model.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionRepository extends JpaRepository<Question, Long> {


}
