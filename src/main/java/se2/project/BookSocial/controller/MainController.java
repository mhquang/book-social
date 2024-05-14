package se2.project.BookSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/browse")
    public String browse() {
        return "browse";
    }

    @GetMapping("/browse/toprated")
    public String topRatedBook() {
        return "toprated";
    }
    @GetMapping("/user")
    public String user() {
        return "user";
    }

}
