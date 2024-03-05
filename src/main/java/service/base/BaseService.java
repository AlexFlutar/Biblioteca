package service.base;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.entity.EntityBook;
import repository.entity.EntityPerson;

public abstract class BaseService {
    protected final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(EntityBook.class)
            .addAnnotatedClass(EntityPerson.class)
            .buildSessionFactory();
}
