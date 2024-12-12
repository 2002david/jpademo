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
        person.setVorname("Max");
        person.setNachname("Mustermann");
        person.setGeburtsdatum(java.sql.Date.valueOf("1970-01-01"));

        personDAO.save(person);

        PersonEntity savedPerson = personDAO.find(person.getPersonId());
        System.out.println(savedPerson.getVorname());
    }
}