package ru.rsreu.Babaian.ElectronicStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.Babaian.ElectronicStore.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
