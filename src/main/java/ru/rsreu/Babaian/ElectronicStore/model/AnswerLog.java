package ru.rsreu.Babaian.ElectronicStore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers_logs")
public class AnswerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp answeredAt;

    @NotBlank(message = "Enter answer")
    private String answer;

    @NotNull(message = "Choose question")
    @ManyToOne
    @JoinColumn(name="questionId", referencedColumnName = "id", nullable = false)
    private Question question;


    //@NotNull(message = "Choose question")
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;



}
