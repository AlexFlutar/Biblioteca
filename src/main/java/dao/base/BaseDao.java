package dao.base;

import jakarta.persistence.EntityManager;

public abstract class BaseDao {
    protected final EntityManager entityManager;

    protected BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
