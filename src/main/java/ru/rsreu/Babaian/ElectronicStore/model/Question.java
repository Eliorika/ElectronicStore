package ru.rsreu.Babaian.ElectronicStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String question;
    private String answer;
}
