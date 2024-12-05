package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "schueler", schema = "public", catalog = "dstegl2s")
public class SchuelerEntity {

    @Id
    @OneToOne
    private PersonEntity personId;

    @Column(name = "einschulungsjahr")
    private Date einschulungsjahr;

    @ManyToOne
    private KlasseEntity klasse;

    public Date getEinschulungsjahr() {
        return einschulungsjahr;
    }

    public void setEinschulungsjahr(Date einschulungsjahr) {
        this.einschulungsjahr = einschulungsjahr;
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
