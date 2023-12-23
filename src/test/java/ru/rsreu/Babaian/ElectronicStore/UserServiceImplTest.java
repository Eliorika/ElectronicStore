package ru.rsreu.Babaian.ElectronicStore;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.Babaian.ElectronicStore.services.Impl.UserServiceImpl;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;


    private RegistrationUserRequest req = new RegistrationUserRequest("login", "b@a.com", "password", "password");

    @Transactional
    @Rollback
    @Test
    void test_create_user(){
        userService.createUser(req);
        User user = userRepo.findByLogin(req.getLogin());

        Assertions.assertEquals(user.getLogin(), req.getLogin());
    }

    @Transactional
    @Rollback
    @Test
    void test_rename_user(){
        userService.createUser(req);
        User user = userRepo.findByLogin(req.getLogin());

        Assertions.assertEquals(user.getLogin(), req.getLogin());

        user = userService.rename(user.getLogin(), "new_login");

        Assertions.assertEquals("new_login", user.getLogin());
    }


    @Transactional
    @Rollback
    @Test
    void test_delete_user(){
        userService.createUser(req);
        User user = userRepo.findByLogin(req.getLogin());

        userService.delete(user.getLogin());

        var res = userRepo.findByLogin(user.getLogin());

        Assertions.assertNull(res);
    }

    @Transactional
    @Rollback
    @Test
    @Sql({"/user.sql"})
    void test_add_user(){

        var res = userRepo.findByLogin("user");

        Assertions.assertEquals("user", res.getLogin());
    }
}