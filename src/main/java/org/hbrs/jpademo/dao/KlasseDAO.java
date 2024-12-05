package org.hbrs.jpademo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.KlasseEntity;

public class KlasseDAO {

    private EntityManagerFactory emf;

    public KlasseDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpademo");
    }

    public void save(KlasseEntity klasse) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(klasse);
        em.getTransaction().commit();
        em.close();
    }

    public KlasseEntity find(int id) {
        EntityManager em = emf.createEntityManager();
        KlasseEntity klasse = em.find(KlasseEntity.class, id);
        em.close();
        return klasse;
    }
}