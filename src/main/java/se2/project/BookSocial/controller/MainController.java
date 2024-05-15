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
import se2.project.BookSocial.model.Author;
import se2.project.BookSocial.model.Book;
import se2.project.BookSocial.model.Bookshelf;
import se2.project.BookSocial.model.Genre;
import se2.project.BookSocial.model.MyUserDetails;
import se2.project.BookSocial.model.User;
import se2.project.BookSocial.repository.BookRepository;
import se2.project.BookSocial.repository.GenreRepository;
import se2.project.BookSocial.repository.UserRepository;
import se2.project.BookSocial.repository.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookshelfRepository bookshelfRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String getHome(Model model) {
        List<Book> books = bookRepository.findAll();
        List<Bookshelf> bookshelves = bookshelfRepository.findAll();
        model.addAttribute("books" , books);
        model.addAttribute("bookshelves", bookshelves);
        return "home";
    }

    @GetMapping("/browse")
    public String getBrowse(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books" , books);
        return "browse";
    }
    @GetMapping("/mybooks")
    public String getMyBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books" , books);
        return "mybooks";
    }

    @GetMapping("/browse/toprated")
    public String getTopRatedBook(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books" , books);
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
    public String getTrending(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books" , books);
        return "trending";
    }

    @GetMapping("/browse/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres" , genres);
        return "genres";
    }

    @GetMapping("/browse/author")
    public String getAuthor() {
        return "author";
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
