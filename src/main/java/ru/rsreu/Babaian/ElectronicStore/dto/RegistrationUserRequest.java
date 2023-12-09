package ru.rsreu.Babaian.ElectronicStore.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.Babaian.ElectronicStore.dto.interfaces.PasswordMatches;
import ru.rsreu.Babaian.ElectronicStore.dto.interfaces.ValidEmail;
import ru.rsreu.Babaian.ElectronicStore.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@PasswordMatches
public class RegistrationUserRequest {

    @NotBlank
    private String login;

    @NotBlank
    @ValidEmail
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordRepeat;

    public User toUser(PasswordEncoder passwordEncoder){
        return User.builder()
                .login(login)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
