package repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import repository.entity.base.BaseEntity;

@Entity(name = "Book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
    EntityPerson person;

}
