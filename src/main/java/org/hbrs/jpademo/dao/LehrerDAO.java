package org.hbrs.jpademo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.LehrerEntity;

public class LehrerDAO {

    private EntityManagerFactory emf;

    public LehrerDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpademo");
    }

    public void save(LehrerEntity lehrer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(lehrer);
        em.getTransaction().commit();
        em.close();
    }

    public LehrerEntity find(int id) {
        EntityManager em = emf.createEntityManager();
        LehrerEntity lehrer = em.find(LehrerEntity.class, id);
        em.close();
        return lehrer;
    }
}