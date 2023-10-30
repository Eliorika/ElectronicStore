package ru.rsreu.Babaian.ElectronicStore.repo;

import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;
import ru.rsreu.Babaian.ElectronicStore.model.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionRepository {
    List<Question> findAll();
    Optional<Question> findById(Long id);

    Question save(Question question);
}
