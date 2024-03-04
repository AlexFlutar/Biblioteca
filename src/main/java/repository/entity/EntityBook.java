package repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "Book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EntityBook {

    @Column(name = "id")
    @NonNull
    private int id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "author")
    @NonNull
    private String author;

    @Column(name = "genre")
    @NonNull
    private String genre;
}
