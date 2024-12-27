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



}
