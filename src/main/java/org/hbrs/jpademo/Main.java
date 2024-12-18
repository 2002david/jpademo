package org.hbrs.jpademo;

import org.hbrs.jpademo.model.Person;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting jpademo - " + LocalDateTime.now());

        DAO<Person> personDAO = new DAO<>(Person.class);

        Person person = new Person();
        person.setPersonId(0);
        person.setVorname("Max");
        person.setNachname("Mustermann");
        person.setGeburtsdatum(java.sql.Date.valueOf("1970-01-01"));

        personDAO.save(person);

        Person savedPerson = personDAO.find(person.getPersonId());
        System.out.println(savedPerson.getVorname());
    }
}