package org.hbrs.jpademo;

import org.hbrs.jpademo.model.Lehrer;
import org.hbrs.jpademo.model.Person;
import org.hbrs.jpademo.model.Schueler;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        DAO<Lehrer> lehrerDAO = new DAO<>(Lehrer.class);
        DAO<Schueler> schuelerDAO = new DAO<>(Schueler.class);

        // Lehrer
        Lehrer lehrer = new Lehrer();
        lehrer.setVorname("Max");
        lehrer.setNachname("Mustermann");
        lehrer.setGeburtsdatum(java.sql.Date.valueOf("1970-01-02"));
        lehrer.setGehalt(6000.0);

        lehrerDAO.save(lehrer);

        // Schueler
        Schueler schueler = new Schueler();
        schueler.setVorname("Erika");
        schueler.setNachname("Musterman");
        schueler.setGeburtsdatum(java.sql.Date.valueOf("1970-01-03"));
        schueler.setEinschulungsjahr(java.sql.Date.valueOf("1976-01-02"));

        schuelerDAO.save(schueler);

        // find "Lehrer"
        Lehrer savedLehrer = lehrerDAO.find(lehrer.getPersonId());
        System.out.println(savedLehrer.getVorname());
    }
}