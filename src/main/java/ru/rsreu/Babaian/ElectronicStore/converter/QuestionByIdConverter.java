package ru.rsreu.Babaian.ElectronicStore.converter;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.Babaian.ElectronicStore.model.Question;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;

@Component
@AllArgsConstructor
public class QuestionByIdConverter implements Converter<String, Question> {

    private IQuestionRepository iQuestionRepository;
    @Override
    public Question convert(String id) {
        try {
            if(iQuestionRepository.findById(Long.valueOf(id)).isPresent())
                return iQuestionRepository.findById(Long.valueOf(id)).get();
            else return null;
        } catch (Exception e){
            return null;
        }

    }
}
