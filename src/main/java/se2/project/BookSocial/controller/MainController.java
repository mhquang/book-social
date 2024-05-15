package se2.project.BookSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/browse")
    public String getBrowse() {
        return "browse";
    }
    @GetMapping("/mybooks")
    public String getMyBooks() {
        return "mybooks";
    }

    @GetMapping("/browse/toprated")
    public String getTopRatedBook() {
        return "toprated";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

    @GetMapping("/browse/trending")
    public String getTrending() {
        return "trending";
    }

    @GetMapping("/browse/genres")
    public String getGenres() {
        return "genres";
    }

    @GetMapping("/browse/author")
    public String getAuthor() {
        return "author";
    }
    @GetMapping("/bookdetail")
    public String getBookDetail() {
        return "bookdetail";
    }

    @GetMapping("/quotes")
    public String getQuotes() {
        return "quotes";
    }
    @GetMapping("/quotes/myquotes")
    public String getMyQuotes() {
        return "myquotes";
    }
    @GetMapping("/quotes/addquotes")
    public String getAddQuotes() {
        return "addquotes";
    }
}
