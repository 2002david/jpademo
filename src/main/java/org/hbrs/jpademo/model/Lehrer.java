package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Lehrer extends Person {

    private Double gehalt;

    @OneToOne
    private Klasse klasse;

    @ManyToMany
    @JoinTable(name = "unterrichtet_fach",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<Fach> faecher;


    @OneToMany(mappedBy = "lehrer")
    private List<Unterrichtet_Klasse> unterrichtet_klassen;

    @ManyToOne
    private Lehrer schulleiter;

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

    public List<Unterrichtet_Klasse> getUnterrichtet_klassen() {
        return unterrichtet_klassen;
    }

    public void setUnterrichtet_klassen(List<Unterrichtet_Klasse> unterrichtet_klassen) {
        this.unterrichtet_klassen = unterrichtet_klassen;
    }

    public Lehrer getSchulleiter() {
        return schulleiter;
    }

    public void setSchulleiter(Lehrer schulleiter) {
        this.schulleiter = schulleiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lehrer lehrer = (Lehrer) o;
        return Objects.equals(gehalt, lehrer.gehalt) && Objects.equals(klasse, lehrer.klasse) && Objects.equals(faecher, lehrer.faecher) && Objects.equals(unterrichtet_klassen, lehrer.unterrichtet_klassen) && Objects.equals(schulleiter, lehrer.schulleiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gehalt, klasse, faecher, unterrichtet_klassen, schulleiter);
    }
}
