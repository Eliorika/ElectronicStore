package ru.rsreu.Babaian.ElectronicStore.services;

import ru.rsreu.Babaian.ElectronicStore.model.Question;

import java.util.List;

public interface IQuestionService {
    Question createQuestion(String q, String a);


    List<Question> findAll();
}
