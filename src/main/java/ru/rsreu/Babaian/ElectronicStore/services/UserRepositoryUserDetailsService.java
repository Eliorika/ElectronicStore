package ru.rsreu.Babaian.ElectronicStore.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IUserRepo;

@Service
@AllArgsConstructor
public class UserRepositoryUserDetailsService 
        implements UserDetailsService {

  private IUserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User user = userRepo.findByLogin(username);
    if (user != null) {
      return user;
    }
    throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
  }

}
