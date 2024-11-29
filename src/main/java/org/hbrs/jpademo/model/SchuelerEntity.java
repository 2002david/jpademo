package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "schueler", schema = "public", catalog = "dstegl2s")
public class SchuelerEntity {
    @Id
    @Column(name = "person_id")
    private int personId;
    @Column(name = "einschulungsjahr")
    private Date einschulungsjahr;
    @Column(name = "klasse")
    private String klasse;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getEinschulungsjahr() {
        return einschulungsjahr;
    }

    public void setEinschulungsjahr(Date einschulungsjahr) {
        this.einschulungsjahr = einschulungsjahr;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchuelerEntity that = (SchuelerEntity) o;
        return personId == that.personId && Objects.equals(einschulungsjahr, that.einschulungsjahr) && Objects.equals(klasse, that.klasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, einschulungsjahr, klasse);
    }
}
