package se2.project.BookSocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se2.project.BookSocial.service.JpaUserDetailsService;


@Controller
public class UserController {
    @Autowired
    JpaUserDetailsService jpaUserDetailsService;

    @GetMapping("home")
    public String userPage(Model model) {
        return "user";
    }
}
