package repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(name = "Rent_books")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EntityRentBooks {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Person_cnp")
    private EntityPerson entityPerson;

    @OneToMany(mappedBy="Person_cnp")
    private List<EntityBook> entityBookList;

    @Column(name = "rent_time_days")
    @NotNull
    int days;
}
