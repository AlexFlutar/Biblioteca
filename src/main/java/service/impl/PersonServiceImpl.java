package service.impl;


import dao.PersonDAO;
import dao.impl.PersonDAOImpl;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;
import service.BookService;
import service.PersonService;
import service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl extends BaseService implements PersonService {

    private PersonDAO personDAO;

    public PersonServiceImpl() {
        this.personDAO = new PersonDAOImpl(sessionFactory.createEntityManager());
    }
    @Override
    public EntityPerson save(EntityPerson person) {
        return this.personDAO.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        this.personDAO.deleteById(id);
    }

    @Override
    public Optional<EntityPerson> findById(Integer id) {
        return this.personDAO.findById(id);
    }

    @Override
    public List<EntityPerson> findAll() {
        return this.personDAO.findAll();
    }
}
