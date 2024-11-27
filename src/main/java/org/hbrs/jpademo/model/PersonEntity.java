package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "dstegl2s")
public class PersonEntity {
    @Id
    @Basic
    @Column(name = "person_id")
    private int personId;
    @Basic
    @Column(name = "vorname")
    private String vorname;
    @Basic
    @Column(name = "nachname")
    private String nachname;
    @Basic
    @Column(name = "geburtsdatum")
    private Date geburtsdatum;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return personId == that.personId && Objects.equals(vorname, that.vorname) && Objects.equals(nachname, that.nachname) && Objects.equals(geburtsdatum, that.geburtsdatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, vorname, nachname, geburtsdatum);
    }
}
