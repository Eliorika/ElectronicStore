package ru.rsreu.Babaian.ElectronicStore.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;
import ru.rsreu.Babaian.ElectronicStore.repo.IUserRepo;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showRegistration(Model model){
        return "registration";
    }
    public IUserRepo userRepo;
    @PostMapping
    public String registration(RegistrationUserRequest req){
        userRepo.save(req.toUser(passwordEncoder));
        return "home";
    }

    @ModelAttribute
    public void addQuestionsToModel(Model model){
        model.addAttribute("userRegReq", new RegistrationUserRequest());
    }
}
