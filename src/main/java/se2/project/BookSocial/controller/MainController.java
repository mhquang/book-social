package se2.project.BookSocial.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se2.project.BookSocial.model.Book;
import se2.project.BookSocial.model.Genre;
import se2.project.BookSocial.model.MyUserDetails;
import se2.project.BookSocial.model.User;
import se2.project.BookSocial.repository.BookRepository;
import se2.project.BookSocial.repository.GenreRepository;
import se2.project.BookSocial.repository.UserRepository;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/")
    public String getHome(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books" , books);
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
    public String manipulateUser(
            @AuthenticationPrincipal MyUserDetails myUserDetails, Model model) {
        User user = userRepository.getById(myUserDetails.getId());
        model.addAttribute("user", user);
        model.addAttribute("myUserDetails", myUserDetails);
        return "user";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUpdate(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user";
        }
        userRepository.save(user);
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
    @GetMapping("/book/{id}")
    public String getBookDetail(@PathVariable Long id, Model model) {
        Book book = bookRepository.getById(id);
        List<Genre> genres = genreRepository.findByBooksId(id);
        model.addAttribute("book", book);
        model.addAttribute("genres", genres);
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
