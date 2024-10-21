package org.ihorshein.lesson5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.exception.ConstraintViolationException;
import org.ihorshein.lesson5.util.DbConnection;

import java.util.Optional;
import java.util.function.Consumer;

public abstract class RepositoryMysql {
  private <T> void transactionRun(Consumer<T> call, EntityManager entityManager, T entity) {
    EntityTransaction transaction = null;

    try {
      transaction = entityManager.getTransaction();
      transaction.begin();

      call.accept(entity);

      transaction.commit();
    } catch (ConstraintViolationException e) {
      transactionRollback(transaction);
      throw new RuntimeException("Entity already exists.", e);
    } catch (Exception e) {
      transactionRollback(transaction);
    }
  }

  private void transactionRollback(EntityTransaction transaction) {
    if (transaction != null && transaction.isActive()) {
      transaction.rollback();
    }
  }

  public <T> Optional<T> findById(Class<T> entityClass, String sqlQuery) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      return Optional.ofNullable(entityManager
        .createQuery(sqlQuery, entityClass)
        .getResultList()
        .getFirst());
    }
  }

  protected <T> T addDb(T entity) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      transactionRun(entityManager::persist, entityManager, entity);
    }

    return entity;
  }

  protected <T> T updateDb(T entity) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      transactionRun(entityManager::merge, entityManager, entity);
    }

    return entity;
  }
}
