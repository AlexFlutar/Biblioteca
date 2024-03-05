package repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import repository.entity.base.BaseEntityBook;

@Entity(name = "Book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EntityBook extends BaseEntityBook {

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
    @JoinColumn(name="Person_cnp")
    EntityRentBooks entityRentBooks;
}
