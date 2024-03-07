package dao.impl;

import dao.BookDAO;
import dao.base.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.entity.EntityBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAOImpl extends BaseDao implements BookDAO {
    public BookDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public EntityBook save(EntityBook book) {
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(book);


            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return book;
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
            Optional<EntityBook> found = Optional.ofNullable(entityManager.find(EntityBook.class, id));  // select * from movie where id = <id>
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
    public Optional<EntityBook> findById(Integer id) {
        EntityTransaction transaction = null;
        Optional<EntityBook> found = Optional.empty();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(EntityBook.class, id));

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
    public List<EntityBook> findAll() {
        EntityTransaction transaction = null;
        List<EntityBook> resultList = new ArrayList<>();


        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createNativeQuery("SELECT * FROM Book1", EntityBook.class).getResultList();

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
