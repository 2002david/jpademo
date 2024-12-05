package org.hbrs.jpademo.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.FachEntity;

public class FachDAO {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpademo");
    }

    public void save(FachEntity adresse){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(adresse);
        em.getTransaction().commit();
        em.close();
    }

    public FachEntity find(int id){
        EntityManager em = emf.createEntityManager();
        FachEntity fach = em.find(FachEntity.class, id);
        em.close();
        return fach;
    }
}
