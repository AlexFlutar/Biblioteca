package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import repository.entity.EntityBook;
import service.BookService;
import service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl extends BaseService implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() {
        this.bookDAO = new BookDAOImpl(sessionFactory.createEntityManager());
    }
    @Override
    public EntityBook save(EntityBook book) {
        return this.bookDAO.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        this.bookDAO.deleteById(id);
    }

    @Override
    public Optional<EntityBook> findById(Integer id) {
        return this.bookDAO.findById(id);
    }

    @Override
    public List<EntityBook> findAll() {
        return this.bookDAO.findAll();
    }
}
