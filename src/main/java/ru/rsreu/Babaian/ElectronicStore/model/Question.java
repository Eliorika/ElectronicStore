package ru.rsreu.Babaian.ElectronicStore.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar")
    private String question;

    @Column(columnDefinition = "varchar")
    private String answer;
}
