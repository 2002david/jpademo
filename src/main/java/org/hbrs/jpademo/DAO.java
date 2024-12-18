package org.hbrs.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAO<T> {

    private final EntityManagerFactory emf;
    private final Class<T> type;

    public DAO(Class<T> type) {
        this.emf = Persistence.createEntityManagerFactory("jpademo");
        this.type = type;
    }

    public void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    public T find(int id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(type, id);
        em.close();
        return t;
    }

}
