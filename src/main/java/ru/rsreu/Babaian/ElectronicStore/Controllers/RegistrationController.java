package ru.rsreu.Babaian.ElectronicStore.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    @GetMapping
    public String showRegistration(Model model){
        return "registration";
    }
    @PostMapping
    public void auth(){

    }

    @ModelAttribute
    public void addQuestionsToModel(Model model){
        model.addAttribute("userRegReq", new RegistrationUserRequest());
    }
}
