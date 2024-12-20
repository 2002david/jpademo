package org.hbrs.jpademo;

import org.hbrs.jpademo.model.Lehrer;
import org.hbrs.jpademo.model.Person;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        DAO<Lehrer> lehrerDAO = new DAO<>(Lehrer.class);

        Lehrer lehrer = new Lehrer();
        lehrer.setPersonId(0);
        lehrer.setVorname("Max");
        lehrer.setNachname("Mustermann");
        lehrer.setGeburtsdatum(java.sql.Date.valueOf("1970-01-01"));
        lehrer.setGehalt(5000.0);

        lehrerDAO.save(lehrer);

        Lehrer savedLehrer = lehrerDAO.find(lehrer.getPersonId());
        System.out.println(savedLehrer.getVorname());
    }
}