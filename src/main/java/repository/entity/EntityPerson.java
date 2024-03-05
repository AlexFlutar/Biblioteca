package repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import repository.entity.base.BaseEntity;

import java.util.List;

@Entity(name = "Person")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EntityPerson  {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    protected Integer personId;

    @Column(name = "cnp")
    @NonNull
    private String cnp;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @OneToMany(mappedBy = "person")
    List<EntityBook> bookList;

}
