package org.ihorshein.lesson5.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class DbConnection {
    @Getter
    private static EntityManagerFactory mysqlFactory = initMysqlFactory();

    private static EntityManagerFactory initMysqlFactory() {
        try {
            return Persistence.createEntityManagerFactory("mysql_java_hw");
        } catch (Exception e) {
            throw new RuntimeException("Can't create entity manager factory ", e);
        }
    }

    /**
     * When the application has finished using the entity manager factory, and/or at application shutdown,
     *  the application should close the entity manager factory.
     * Once an EntityManagerFactory has been closed, all its entity managers are considered to be in the closed state.
     */
    public static void close() {
        mysqlFactory.close();
    }
}