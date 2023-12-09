package ru.rsreu.Babaian.ElectronicStore.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.dto.interfaces.PasswordMatches;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationUserRequest> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegistrationUserRequest user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getPasswordRepeat());
    }
}
