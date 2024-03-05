package dao.impl;

import dao.BookDAO;
import dao.base.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.entity.EntityBook;

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

    }

    @Override
    public Optional<EntityBook> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<EntityBook> findAll() {
        return null;
    }
}
