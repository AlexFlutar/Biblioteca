package repository.entity.base;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntityPerson {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnp")
    private Integer cnp;
}
