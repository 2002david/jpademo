package org.hbrs.jpademo.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hbrs.jpademo.DAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import jakarta.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class SchuelerTest {

    static EntityManager em;

    @BeforeAll
    static void beforeAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");
        em = emf.createEntityManager();
    }

    @Test
    void testCreateSchueler() {
        // create Schueler via DAO
        DAO<Schueler> schuelerDAO = new DAO<>(Schueler.class);

        Schueler schueler = new Schueler();
        schueler.setVorname("Peter");
        schueler.setNachname("Mustermann");
        schueler.setGeburtsdatum(Date.valueOf("2000-01-01"));
        schueler.setEinschulungsjahr(Date.valueOf("2006-01-01"));

        schuelerDAO.save(schueler);

        // find "Schueler" via named query
        Schueler foundSchueler = em.createNamedQuery("Schueler.findByPersonId", Schueler.class)
                .setParameter("personId", schueler.getPersonId())
                .getSingleResult();

        assertEquals(schueler, foundSchueler);
    }

    @AfterAll
    static void afterAll() {
        em.close();
    }
}