package se2.project.BookSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2.project.BookSocial.model.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByBooksId(Long bookId);
}
