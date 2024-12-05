package org.hbrs.jpademo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.AdresseEntity;


public class AdresseDAO {
   private static final EntityManagerFactory emf;

   static {
       emf = Persistence.createEntityManagerFactory("jpademo");
   }

   public void save(AdresseEntity adresse){
       EntityManager em = emf.createEntityManager();
           em.getTransaction().begin();
           em.persist(adresse);
           em.getTransaction().commit();
           em.close();
       }

       public AdresseEntity find(int id){
           EntityManager em = emf.createEntityManager();
           AdresseEntity adresse = em.find(AdresseEntity.class, id);
           em.close();
           return adresse;
       }
}
