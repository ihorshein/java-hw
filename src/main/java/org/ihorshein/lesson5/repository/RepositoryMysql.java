package org.ihorshein.lesson5.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.exception.ConstraintViolationException;
import org.ihorshein.lesson5.util.DbConnection;

import java.util.List;
import java.util.function.Consumer;

public abstract class RepositoryMysql {
  private <T> void transactionRun(Consumer<T> call, EntityTransaction transaction, T entity) {
    try {
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

  public <T> List<T> find(Class<T> entityClass, String sqlQuery) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      return entityManager
        .createQuery(sqlQuery, entityClass)
        .getResultList();
    }
  }

  protected <T> T addDb(T entity) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      transactionRun(entityManager::persist, entityManager.getTransaction(), entity);
    }

    return entity;
  }

  protected <T> T updateDb(T entity) {
    try (EntityManager entityManager = DbConnection.getMysqlFactory().createEntityManager()) {
      transactionRun(entityManager::merge, entityManager.getTransaction(), entity);
    }

    return entity;
  }
}
