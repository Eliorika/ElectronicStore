package ru.rsreu.Babaian.ElectronicStore.dto;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.Babaian.ElectronicStore.model.User;

@Data
public class RegistrationUserRequest {

    private String login;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder().login(login).password(passwordEncoder.encode(password)).build();
    }
}
