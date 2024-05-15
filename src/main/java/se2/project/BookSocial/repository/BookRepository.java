package se2.project.BookSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2.project.BookSocial.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
