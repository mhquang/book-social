package se2.project.BookSocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se2.project.BookSocial.dto.UserDto;
import se2.project.BookSocial.model.User;
import se2.project.BookSocial.repository.UserRepository;
import se2.project.BookSocial.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            model.addAttribute("userExisted", user);
            return "register";
        } else {
            userService.save(userDto);
            model.addAttribute("message", "Registered Successfuly!");
//            return "redirect:/register?success";
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("homepage")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "homepage";
    }
    @GetMapping("/browse")
    public String getBrowse(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "browse";
    }
    @GetMapping("/toprated")
    public String getTopRated(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "toprated";
    }
    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }

}
