package repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import repository.entity.base.BaseEntityPerson;

@Entity(name = "Person")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EntityPerson extends BaseEntityPerson {

    @Column(name = "cnp")
    @NonNull
    private int cnp;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;
}
