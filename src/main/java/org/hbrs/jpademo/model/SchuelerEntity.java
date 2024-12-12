package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "schueler", schema = "public", catalog = "dstegl2s")
public class SchuelerEntity {

    @Id
    @OneToOne
    private PersonEntity person;

    @Column(name = "einschulungsjahr")
    private Date einschulungsjahr;

    @ManyToOne
    private KlasseEntity klasse;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Date getEinschulungsjahr() {
        return einschulungsjahr;
    }

    public void setEinschulungsjahr(Date einschulungsjahr) {
        this.einschulungsjahr = einschulungsjahr;
    }

    public KlasseEntity getKlasse() {
        return klasse;
    }

    public void setKlasse(KlasseEntity klasse) {
        this.klasse = klasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchuelerEntity that = (SchuelerEntity) o;
        return Objects.equals(person, that.person) && Objects.equals(einschulungsjahr, that.einschulungsjahr) && Objects.equals(klasse, that.klasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, einschulungsjahr, klasse);
    }
}
