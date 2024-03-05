package dao;

import repository.entity.EntityBook;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    EntityBook save(EntityBook book);

    void deleteById(Integer id);

    Optional<EntityBook> findById(Integer id);

    List<EntityBook> findAll();
}
