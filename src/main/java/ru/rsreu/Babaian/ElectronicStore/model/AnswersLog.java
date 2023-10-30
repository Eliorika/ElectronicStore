package ru.rsreu.Babaian.ElectronicStore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table("answers_log")
public class AnswersLog {

    @Column
    private Long id;
    private Date answeredAt;
    @NotNull(message = "Choose question")
    private Question question;

    @NotBlank(message = "Enter answer")
    private String answer;

    public boolean validate(){
        return question.getAnswer().equals(this.answer);
    }

}
