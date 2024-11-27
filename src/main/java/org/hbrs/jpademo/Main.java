package org.hbrs.jpademo;

import org.hbrs.jpademo.dao.PersonDAO;
import org.hbrs.jpademo.model.PersonEntity;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        PersonDAO personDAO = new PersonDAO();

        PersonEntity person = new PersonEntity();
        person.setPersonId(0);
        person.setVorname("David");
        person.setNachname("Steglich");
        person.setGeburtsdatum(java.sql.Date.valueOf("2002-04-14"));

        personDAO.save(person);

        PersonEntity savedPerson = personDAO.find(person.getPersonId());
        System.out.println(savedPerson.getVorname());
    }
}