package ru.rsreu.Babaian.ElectronicStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnswerLogRepository extends JpaRepository<AnswersLog, Long> {


}
