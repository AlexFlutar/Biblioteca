package repository.entity.base;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
}
