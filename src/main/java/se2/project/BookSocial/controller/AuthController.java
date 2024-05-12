package se2.project.BookSocial.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se2.project.BookSocial.model.User;
import se2.project.BookSocial.model.UserTemplate;
import se2.project.BookSocial.repository.UserRepository;

@Controller
public class AuthController {
    UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserTemplate());
        return "register";
    }

    @PostMapping("/register")
    public String registerHandler(Model model,
                                  @Valid @ModelAttribute("userDTO") UserTemplate userTemplate) {
        User user = userRepository.findByUsername(userTemplate.getUsername());
        if (user != null) {
            model.addAttribute("userExisted", user);
        } else {
            model.addAttribute("user", userTemplate);
            model.addAttribute("message", "Registered Successfully!");
        }
        return "register";
    }
}
