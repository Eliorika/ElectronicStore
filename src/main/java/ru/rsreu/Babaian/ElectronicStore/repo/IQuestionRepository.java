package ru.rsreu.Babaian.ElectronicStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.Babaian.ElectronicStore.model.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long> {


}
