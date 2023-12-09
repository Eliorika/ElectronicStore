package ru.rsreu.Babaian.ElectronicStore.services;

import ru.rsreu.Babaian.ElectronicStore.dto.AnswerLogRequest;
import ru.rsreu.Babaian.ElectronicStore.model.AnswerLog;
import ru.rsreu.Babaian.ElectronicStore.model.User;


public interface IAnswerLogService {

    AnswerLog createAnswerLog(AnswerLogRequest req, User user);

    boolean validate(AnswerLog ans);
}
