package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Lehrer {

    @Id
    @OneToOne
    private Person person;

    private Double gehalt;

    @OneToOne
    private Klasse klasse;

    @ManyToMany
    @JoinTable(name = "unterrichtet_fach",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<Fach> faecher;

    @ManyToMany
    @JoinTable(name = "unterrichtet_klassen",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "klasse_id"))
    private List<Klasse> klassen;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Double getGehalt() {
        return gehalt;
    }

    public void setGehalt(Double gehalt) {
        this.gehalt = gehalt;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public List<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<Fach> faecher) {
        this.faecher = faecher;
    }

    public List<Klasse> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klasse> klassen) {
        this.klassen = klassen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lehrer that = (Lehrer) o;
        return Objects.equals(person, that.person) && Objects.equals(gehalt, that.gehalt) && Objects.equals(klasse, that.klasse) && Objects.equals(faecher, that.faecher) && Objects.equals(klassen, that.klassen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, gehalt, klasse, faecher, klassen);
    }
}
