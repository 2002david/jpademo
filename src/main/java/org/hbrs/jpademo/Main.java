package org.hbrs.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hbrs.jpademo.model.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        DAO<Adresse> adresseDAO = new DAO<>(Adresse.class);
        DAO<Klasse> klasseDAO = new DAO<>(Klasse.class);
        DAO<Lehrer> lehrerDAO = new DAO<>(Lehrer.class);
        DAO<Schueler> schuelerDAO = new DAO<>(Schueler.class);

        // create Adresse via DAO
        Adresse adresse = new Adresse();
        adresse.setStrasse("Musterstraße");
        adresse.setHausnr("1");
        adresse.setPlz("12345");
        adresse.setOrt("Musterstadt");

        adresseDAO.save(adresse);

        // create Klasse via DAO
        Klasse klasse = new Klasse();
        klasse.setKlassenname("10A");

        klasseDAO.save(klasse);

        // create Lehrer via DAO
        Lehrer lehrer = new Lehrer();
        lehrer.setVorname("Max");
        lehrer.setNachname("Mustermann");
        lehrer.setGeburtsdatum(Date.valueOf("1970-01-02"));
        lehrer.setGehalt(6000.0);
        lehrer.setAdresse(adresse);
        lehrer.setKlasse(klasse);

        lehrerDAO.save(lehrer);

        // create Schueler via DAO
        Schueler schueler = new Schueler();
        schueler.setVorname("Erika");
        schueler.setNachname("Mustermann");
        schueler.setGeburtsdatum(Date.valueOf("1980-01-03"));
        schueler.setEinschulungsjahr(Date.valueOf("1986-01-02"));
        schueler.setAdresse(adresse);
        schueler.setKlasse(klasse);

        schuelerDAO.save(schueler);

        // find "Lehrer" via JPQL query
        Repository<Lehrer> lehrerRepository = new Repository<>(Lehrer.class);
        Lehrer savedLehrer = lehrerRepository.findById(lehrer.getPersonId());
        System.out.println("Lehrer:");
        System.out.println(savedLehrer.getVorname());

        // find Adresse from "Lehrer" via JPQL query
        Repository<Adresse> adresseRepository = new Repository<>(Adresse.class);
        Adresse savedLehrerAdresse = adresseRepository.findLehrerAdresse(savedLehrer.getPersonId());
        System.out.println("Adresse von " + savedLehrer.getVorname() + " " + savedLehrer.getNachname() + ":");
        System.out.println(savedLehrerAdresse.getStrasse() + " " + savedLehrerAdresse.getHausnr());

        // find "Schueler" via JPQL query
        Repository<Schueler> schuelerRepository = new Repository<>(Schueler.class);
        List<Schueler> savedSchueler = schuelerRepository.findSchuelerFromKlasse("10A");
        System.out.println("Schüler in Klasse 10A:");
        for (Schueler s : savedSchueler) {
            System.out.println(s.getVorname());
        }

        //find "Schueler" by Address / Named Query
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");
        EntityManager entityManager = emf.createEntityManager();
        String strasse = "Musterstraße";
        String hausnr = "1";

        try {
            List<Schueler> schuelers = entityManager.createNamedQuery("Schueler.findByAddress", Schueler.class)
                    .setParameter("strasse", strasse)
                    .setParameter("hausnr", hausnr)
                    .getResultList();

            if (schuelers.isEmpty()) {
                System.out.println("Schueler konnte nicht gefunden werden.");
            } else {
                for (Schueler s : schuelers) {
                    System.out.println(s.getVorname() + " " + s.getNachname());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}