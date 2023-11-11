package ru.rsreu.Babaian.ElectronicStore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers_logs")
public class AnswersLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date answeredAt;

    @NotBlank(message = "Enter answer")
    private String answer;

    @NotNull(message = "Choose question")
    @ManyToOne
    @JoinColumn(name="questionId", referencedColumnName = "id", nullable = false)
    private Question question;

    public boolean validate(){
        return question.getAnswer().equals(this.answer);
    }

}
