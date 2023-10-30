package ru.rsreu.Babaian.ElectronicStore.repo;

import org.springframework.data.repository.CrudRepository;
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;

import java.util.List;
import java.util.Optional;

public interface IAnswerLogRepository extends CrudRepository<AnswersLog, Long> {
//    List<AnswersLog> findAll();
//    Optional<AnswersLog> findById(Long id);
//
//    AnswersLog save(AnswersLog answersLog);
}
