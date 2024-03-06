package repository.entity;

import jakarta.persistence.*;
import lombok.*;
import repository.entity.base.BaseEntity;

@Entity(name = "Book")

public class EntityBook {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    protected Integer bookId;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "author")
    @NonNull
    private String author;

    @Column(name = "genre")
    @NonNull
    private String genre;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private EntityPerson person;

    public EntityBook(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public EntityPerson getPerson() {
        return person;
    }

    public void setPerson(EntityPerson person) {
        this.person = person;
    }

    public Integer getBookId() {
        return bookId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
