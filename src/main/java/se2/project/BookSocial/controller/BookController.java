package se2.project.BookSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se2.project.BookSocial.model.Author;
import se2.project.BookSocial.model.Book;
import se2.project.BookSocial.model.Genre;
import se2.project.BookSocial.repository.AuthorRepository;
import se2.project.BookSocial.repository.BookRepository;
import se2.project.BookSocial.repository.BookshelfRepository;
import se2.project.BookSocial.repository.GenreRepository;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookshelfRepository bookshelfRepository;

    @GetMapping("/book/{id}")
    public String getBookDetail(@PathVariable Long id, Model model) {
        Book book = bookRepository.getById(id);
        List<Genre> genres = genreRepository.findByBooksId(id);
        List<Author> authors = authorRepository.findByBooksId(id);
        model.addAttribute("book", book);
        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);
        return "bookdetail";
    }


}
