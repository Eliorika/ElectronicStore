package ru.rsreu.Babaian.ElectronicStore.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import ru.rsreu.Babaian.ElectronicStore.model.Question;

@Data
@Builder
public class QuestionResponse {

    private Long id;

    private String question;

    private String answer;


    public QuestionResponse fromQuestion(Question q){
        return QuestionResponse.builder()
                .answer(q.getAnswer())
                .id(q.getId())
                .question(q.getQuestion())
                .build();
    }
}
