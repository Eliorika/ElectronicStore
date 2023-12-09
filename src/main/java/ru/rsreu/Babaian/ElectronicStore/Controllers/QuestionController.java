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
import ru.rsreu.Babaian.ElectronicStore.dto.AnswerLogRequest;
import ru.rsreu.Babaian.ElectronicStore.model.User;
import ru.rsreu.Babaian.ElectronicStore.repo.IAnswerLogRepository;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;
import ru.rsreu.Babaian.ElectronicStore.services.IAnswerLogService;
import ru.rsreu.Babaian.ElectronicStore.services.IQuestionService;
import ru.rsreu.Babaian.ElectronicStore.services.IUserService;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private IQuestionService questionService;
    private IAnswerLogService answerLogService;
    private IUserService userService;
    @GetMapping
    public String showTest(Model model){
//        model.addAttribute("answersLog", new AnswerLog());
//        model.addAttribute("questions", iQuestionRepository.findAll());
          return "questions";
    }

    @ModelAttribute
    public void addQuestionsToModel(Model model){
        model.addAttribute("answersLog", new AnswerLogRequest());
        model.addAttribute("questions", questionService.findAll());
    }

    @PostMapping
    public String processQuestion(@Valid AnswerLogRequest answersLog, Errors errors, Principal principal){
        User user = userService.findByLogin(principal.getName());
        if(errors.hasErrors())
            return "questions";

        //answersLog.setAnsweredAt(new Timestamp(System.currentTimeMillis()));
        var log = answerLogService.createAnswerLog(answersLog, user);

        if(answerLogService.validate(log))
            return "success";
        else return "fail";

    }
}
