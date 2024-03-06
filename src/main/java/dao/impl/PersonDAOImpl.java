package dao.impl;

import dao.BookDAO;
import dao.PersonDAO;
import dao.base.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAOImpl extends BaseDao implements PersonDAO {
    public PersonDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public EntityPerson save(EntityPerson person) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(person); // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return person;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            Optional<EntityPerson> found = Optional.ofNullable(entityManager.find(EntityPerson.class, id));  // select * from movie where id = <id>
            if(found.isPresent()) {
                entityManager.remove(found.get());
            }

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<EntityPerson> findById(Integer id) {
        EntityTransaction transaction = null;
        Optional<EntityPerson> found = Optional.empty();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(EntityPerson.class, id));

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<EntityPerson> findAll() {
        EntityTransaction transaction = null;
        List<EntityPerson> resultList = new ArrayList<>();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM person", EntityPerson.class).getResultList();

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;
    }
}
