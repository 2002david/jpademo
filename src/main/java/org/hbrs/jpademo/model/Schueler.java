package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Schueler {

    @Id
    @OneToOne
    private Person person;

    private Date einschulungsjahr;

    @ManyToOne
    private Klasse klasse;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getEinschulungsjahr() {
        return einschulungsjahr;
    }

    public void setEinschulungsjahr(Date einschulungsjahr) {
        this.einschulungsjahr = einschulungsjahr;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schueler that = (Schueler) o;
        return Objects.equals(person, that.person) && Objects.equals(einschulungsjahr, that.einschulungsjahr) && Objects.equals(klasse, that.klasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, einschulungsjahr, klasse);
    }
}
