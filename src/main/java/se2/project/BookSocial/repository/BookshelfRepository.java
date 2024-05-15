package se2.project.BookSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se2.project.BookSocial.model.Bookshelf;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}
