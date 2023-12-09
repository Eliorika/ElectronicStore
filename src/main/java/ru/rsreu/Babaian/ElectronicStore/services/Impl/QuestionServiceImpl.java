package ru.rsreu.Babaian.ElectronicStore.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsreu.Babaian.ElectronicStore.model.Question;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;
import ru.rsreu.Babaian.ElectronicStore.services.IQuestionService;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    private IQuestionRepository questionRepository;

    @Override
    public Question createQuestion(String q, String a){
        Question qt = new Question();
        qt.setQuestion(q);
        qt.setAnswer(a);
        questionRepository.save(qt);
        return qt;
    };

    @Override
    public List<Question> findAll(){
        return questionRepository.findAll();
    }
}
