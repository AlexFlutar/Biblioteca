package repository.entity.base;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntityBook {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}
