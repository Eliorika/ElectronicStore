package ru.rsreu.Babaian.ElectronicStore.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsreu.Babaian.ElectronicStore.dto.AnswerLogRequest;
import ru.rsreu.Babaian.ElectronicStore.model.AnswerLog;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IAnswerLogRepository;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;
import ru.rsreu.Babaian.ElectronicStore.services.IAnswerLogService;

@Service
@AllArgsConstructor
public class AnswerLogServiceImpl implements IAnswerLogService {
    private IAnswerLogRepository answerLogRepository;
    private IQuestionRepository questionRepository;

    @Override
    public AnswerLog createAnswerLog(AnswerLogRequest req, User user){

        var al = req.toAnswerLog();
        al.setUser(user);
        var q = questionRepository.findById(req.getQuestion_id()).orElse(null);
        al.setQuestion(q);
        answerLogRepository.save(al);
        return al;
    }

    @Override
    public boolean validate(AnswerLog ans){
        return ans.getQuestion().getAnswer().equals(ans.getAnswer());
    }
}
