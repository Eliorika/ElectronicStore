package ru.rsreu.Babaian.ElectronicStore.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IUserRepo;
import ru.rsreu.Babaian.ElectronicStore.services.IUserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private IUserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(RegistrationUserRequest req){
        User user = req.toUser(passwordEncoder);

        user = userRepo.save(user);
        return user;
    }

    @Override
    public User createUser(User user){
        userRepo.save(user);
        return user;
    }

    @Override
    public User findByLogin(String login){
        var user = userRepo.findByLogin(login);
        return user;
    }


    public User rename(String login, String newLogin){
        User user = userRepo.findByLogin(login);
        user.setLogin(newLogin);
        user = userRepo.save(user);
        return user;
    }


    public User delete(String login){
        User user = userRepo.findByLogin(login);
        userRepo.delete(user);
        return user;
    }
}
