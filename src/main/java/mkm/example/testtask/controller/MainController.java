package mkm.example.testtask.controller;

import lombok.AllArgsConstructor;
import mkm.example.testtask.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    UserService userService;

    @GetMapping("/")
    public String main(Model model) {

        model.addAttribute("users", userService.getAll());

        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
