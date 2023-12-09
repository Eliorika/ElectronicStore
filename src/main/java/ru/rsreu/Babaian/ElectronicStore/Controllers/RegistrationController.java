package ru.rsreu.Babaian.ElectronicStore.Controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.Babaian.ElectronicStore.dto.RegistrationUserRequest;
import ru.rsreu.Babaian.ElectronicStore.services.IUserService;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    @GetMapping
    public String showRegistration(Model model){
        model.addAttribute("userRegReq", new RegistrationUserRequest());
        return "registration";
    }
    public IUserService userService;
    @PostMapping
    public String registration(@Valid @ModelAttribute("userRegReq")  RegistrationUserRequest req, Errors errors){
        if(errors.hasErrors()){
            return "registration";
        }
        userService.createUser(req);
        return "redirect:/login";
    }

}
