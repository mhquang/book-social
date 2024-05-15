package se2.project.BookSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2.project.BookSocial.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBooksId(Long bookId);
}
