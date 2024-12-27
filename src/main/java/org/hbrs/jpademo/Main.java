package org.hbrs.jpademo;

import org.hbrs.jpademo.model.Adresse;
import org.hbrs.jpademo.model.Lehrer;
import org.hbrs.jpademo.model.Person;
import org.hbrs.jpademo.model.Schueler;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        DAO<Adresse> adresseDAO = new DAO<>(Adresse.class);
        DAO<Lehrer> lehrerDAO = new DAO<>(Lehrer.class);
        DAO<Schueler> schuelerDAO = new DAO<>(Schueler.class);

        // create Adresse via DAO
        Adresse adresse = new Adresse();
        adresse.setStrasse("Musterstraße");
        adresse.setHausnr("1");
        adresse.setPlz("12345");
        adresse.setOrt("Musterstadt");

        adresseDAO.save(adresse);

        // create Lehrer via DAO
        Lehrer lehrer = new Lehrer();
        lehrer.setVorname("Max");
        lehrer.setNachname("Mustermann");
        lehrer.setGeburtsdatum(java.sql.Date.valueOf("1970-01-02"));
        lehrer.setGehalt(6000.0);
        lehrer.setAdresse(adresse);

        lehrerDAO.save(lehrer);

        // create Schueler via DAO
        Schueler schueler = new Schueler();
        schueler.setVorname("Erika");
        schueler.setNachname("Mustermann");
        schueler.setGeburtsdatum(java.sql.Date.valueOf("1980-01-03"));
        schueler.setEinschulungsjahr(java.sql.Date.valueOf("1986-01-02"));
        schueler.setAdresse(adresse);

        schuelerDAO.save(schueler);

        // find "Lehrer" via JPQL query
        Repository<Lehrer> lehrerRepository = new Repository<>(Lehrer.class);
        Lehrer savedLehrer = lehrerRepository.findById(lehrer.getPersonId());
        System.out.println(savedLehrer.getVorname());

        // find Adresse from "Lehrer" via JPQL query
        Repository<Adresse> adresseRepository = new Repository<>(Adresse.class);
        Adresse savedLehrerAdresse = adresseRepository.findLehrerAdresse(savedLehrer.getPersonId());
        System.out.println(savedLehrerAdresse.getStrasse() + " " + savedLehrerAdresse.getHausnr());
    }
}