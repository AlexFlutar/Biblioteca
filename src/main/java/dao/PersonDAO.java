package dao;

import repository.entity.EntityPerson;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    EntityPerson save(EntityPerson person);

    void deleteById(Integer id);

    Optional<EntityPerson> findById(Integer id);

    List<EntityPerson> findAll();
}
