package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findByName", query="SELECT p FROM Person p WHERE p.vorname = :vorname AND p.nachname = :nachname"),
        @NamedQuery(name = "Person.findByAddress", query = "SELECT p.vorname, p.nachname FROM Person p WHERE p.adresse.strasse = :strasse AND p.adresse.hausnr = :hausnr")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int personId;


    private String vorname;

    private String nachname;

    private Date geburtsdatum;

    @ManyToOne
    private Adresse adresse;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && Objects.equals(vorname, person.vorname) && Objects.equals(nachname, person.nachname) && Objects.equals(geburtsdatum, person.geburtsdatum) && Objects.equals(adresse, person.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, vorname, nachname, geburtsdatum, adresse);
    }

    @Override
    public String toString() {return vorname + " " + nachname + " " + geburtsdatum;}
}
