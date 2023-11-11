package ru.rsreu.Babaian.ElectronicStore.dto;

import lombok.Data;

@Data
public class RegistrationUserRequest {
    String login;
    String password;
}
