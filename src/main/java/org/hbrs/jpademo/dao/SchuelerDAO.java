package org.hbrs.jpademo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.SchuelerEntity;

public class SchuelerDAO {

    private EntityManagerFactory emf;

    public SchuelerDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpademo");
    }

    public void save(SchuelerEntity schueler) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(schueler);
        em.getTransaction().commit();
        em.close();
    }

    public SchuelerEntity find(int id) {
        EntityManager em = emf.createEntityManager();
        SchuelerEntity schueler = em.find(SchuelerEntity.class, id);
        em.close();
        return schueler;
    }
}