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
import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;
import ru.rsreu.Babaian.ElectronicStore.repo.IAnswerLogRepository;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;

import java.util.Date;

@Controller
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private IQuestionRepository iQuestionRepository;
    private IAnswerLogRepository iAnswerLogRepository;
    @GetMapping
    public String showTest(Model model){
//        model.addAttribute("answersLog", new AnswersLog());
//        model.addAttribute("questions", iQuestionRepository.findAll());
          return "questions";
    }

    @ModelAttribute
    public void addQuestionsToModel(Model model){
        model.addAttribute("answersLog", new AnswersLog());
        model.addAttribute("questions", iQuestionRepository.findAll());
    }

    @PostMapping
    public String processQuestion(@Valid AnswersLog answersLog, Errors errors){
        if(errors.hasErrors())
            return "questions";

        answersLog.setAnsweredAt(new Date());
        iAnswerLogRepository.save(answersLog);

        if(answersLog.validate())
            return "success";
        else return "fail";

    }
}
