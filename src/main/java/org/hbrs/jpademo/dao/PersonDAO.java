package org.hbrs.jpademo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.PersonEntity;

public class PersonDAO {

    private EntityManagerFactory emf;

    public PersonDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpademo");
    }

    public void save(PersonEntity person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public PersonEntity find(int id) {
        EntityManager em = emf.createEntityManager();
        PersonEntity person = em.find(PersonEntity.class, id);
        em.close();
        return person;
    }

}
