package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Schueler extends Person {

    private Date einschulungsjahr;

    @ManyToOne
    private Klasse klasse;

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
        if (!super.equals(o)) return false;
        Schueler schueler = (Schueler) o;
        return Objects.equals(einschulungsjahr, schueler.einschulungsjahr) && Objects.equals(klasse, schueler.klasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), einschulungsjahr, klasse);
    }
}
