package se2.project.BookSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se2.project.BookSocial.model.Book;
import se2.project.BookSocial.repository.BookRepository;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    BookRepository bookRepository;
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
    @GetMapping("/book/{id}")
    public String getBookDetail(@PathVariable Long id, Model model) {
        Book book = bookRepository.getById(id);
        model.addAttribute("book", book);
        return "bookdetail";
    }

}
