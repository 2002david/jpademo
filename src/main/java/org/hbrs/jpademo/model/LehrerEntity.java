package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lehrer", schema = "public", catalog = "dstegl2s")
public class LehrerEntity {

    @Id
    @OneToOne
    private PersonEntity person;

    @Column(name = "gehalt")
    private Double gehalt;

    @OneToOne
    private KlasseEntity klasse;

    @ManyToMany
    @Column(name = "faecher")
    @JoinTable(name = "unterrichtet_fach",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<FachEntity> faecher;

    @ManyToMany
    @Column(name = "klasse")
    @JoinTable(name = "unterrichtet_klassen",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "klasse_id"))
    private List<KlasseEntity> klassen;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Double getGehalt() {
        return gehalt;
    }

    public void setGehalt(Double gehalt) {
        this.gehalt = gehalt;
    }

    public KlasseEntity getKlasse() {
        return klasse;
    }

    public void setKlasse(KlasseEntity klasse) {
        this.klasse = klasse;
    }

    public List<FachEntity> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<FachEntity> faecher) {
        this.faecher = faecher;
    }

    public List<KlasseEntity> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<KlasseEntity> klassen) {
        this.klassen = klassen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LehrerEntity that = (LehrerEntity) o;
        return Objects.equals(person, that.person) && Objects.equals(gehalt, that.gehalt) && Objects.equals(klasse, that.klasse) && Objects.equals(faecher, that.faecher) && Objects.equals(klassen, that.klassen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, gehalt, klasse, faecher, klassen);
    }
}
