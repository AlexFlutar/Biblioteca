package service;

import controller.IncorrectCnpException;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    EntityPerson save(EntityPerson person) throws IncorrectCnpException;

    void deleteById(Integer id);

    Optional<EntityPerson> findById(Integer id);

    List<EntityPerson> findAll();
}
