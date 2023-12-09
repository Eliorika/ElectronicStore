package ru.rsreu.Babaian.ElectronicStore.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    @GetMapping
    public String showRegistration(Model model){
        return "login";
    }
    @PostMapping
    public String auth(){
        return "home";
    }

//    @GetMapping("/reg")
//    public String goToReg(){
//        return "redirect:registration";
//    }

//    @ModelAttribute
//    public void addQuestionsToModel(Model model){
//        model.addAttribute("userRegReq", new RegistrationUserRequest());
//    }
}
