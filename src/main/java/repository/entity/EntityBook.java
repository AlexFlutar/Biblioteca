package repository.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;
import repository.entity.base.BaseEntity;

@Entity(name = "Book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
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

}
