package ru.rsreu.Babaian.ElectronicStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import ru.rsreu.Babaian.ElectronicStore.model.AnswerLog;

import java.sql.Timestamp;

@Data
public class AnswerLogRequest {
    @CreationTimestamp
    private Timestamp answeredAt;

    @NotBlank(message = "Enter answer")
    private String answer;

    @NotNull(message = "Choose question")
    private Long question_id;

    public AnswerLog toAnswerLog(){
        return AnswerLog.builder()
                .answer(answer)
                .build();

    }
}
