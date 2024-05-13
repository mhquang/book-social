package se2.project.BookSocial.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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
            return "register";
        } else {
            model.addAttribute("user", userTemplate);
            model.addAttribute("message", "Registered Successfully!");

            User newUser = new User();
            newUser.setUsername(userTemplate.getUsername());
            newUser.setPassword(passwordEncoder.encode(userTemplate.getPassword()));
            newUser.setFullname(userTemplate.getFullname());
            userRepository.save(newUser);

            return "redirect:/login";
        }
    }
}
