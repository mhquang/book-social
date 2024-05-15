package se2.project.BookSocial.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String cover;
    private String description;
    private double overallRating;
    private int ratingsNumber;
    private int reviewsNumber;

    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    @ManyToOne
    private Bookshelf bookshelf;

    public Book() {
    }

    public Book(Long id, String title,
                String cover, String description,
                double overallRating,
                int ratingsNumber, int reviewsNumber) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.description = description;
        this.overallRating = overallRating;
        this.ratingsNumber = ratingsNumber;
        this.reviewsNumber = reviewsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public int getRatingsNumber() {
        return ratingsNumber;
    }

    public void setRatingsNumber(int ratingsNumber) {
        this.ratingsNumber = ratingsNumber;
    }

    public int getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(int reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }
}
