package dao.impl;

import dao.BookDAO;
import dao.PersonDAO;
import dao.base.BaseDao;
import jakarta.persistence.EntityManager;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;

import java.util.List;
import java.util.Optional;

public class PersonDAOImpl extends BaseDao implements PersonDAO {
    public PersonDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public EntityPerson save(EntityPerson person) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<EntityPerson> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<EntityPerson> findAll() {
        return null;
    }
}
