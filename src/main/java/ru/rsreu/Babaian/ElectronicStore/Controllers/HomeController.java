package ru.rsreu.Babaian.ElectronicStore.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
/* Контроллер */

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; /* Возвращает имя представления */
    }
}
