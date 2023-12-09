package ru.rsreu.Babaian.ElectronicStore.services;

import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.model.User;

public interface IUserService {


    User createUser(RegistrationUserRequest req);

    User createUser(User user);

    User findByLogin(String login);
}
