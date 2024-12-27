package org.hbrs.jpademo.model;

import jakarta.persistence.*;

@Entity
public class Unterrichtet_Klasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unterrichtet_fach_id;

    @ManyToOne
    @JoinColumn(name ="person_id")
    private Lehrer lehrer;

    @ManyToOne
    @JoinColumn(name ="klasse_id")
    private Klasse klasse;

    @ManyToOne
    @JoinColumn(name ="fach_id")
    private Fach fach;

    public Unterrichtet_Klasse() {}

    public Unterrichtet_Klasse(Lehrer lehrer, Klasse klasse, Fach fach) {
        this.lehrer = lehrer;
        this.klasse = klasse;
        this.fach = fach;
    }

    public int getUnterrichtet_fach_id() {
        return unterrichtet_fach_id;
    }
    public void setUnterrichtet_fach_id(int unterrichtet_fach_id) {
        this.unterrichtet_fach_id = unterrichtet_fach_id;
    }
    public Lehrer getLehrer() {
        return lehrer;
    }
    public void setLehrer(Lehrer lehrer) {
        this.lehrer = lehrer;
    }

    public Klasse getKlasse() {
        return klasse;
    }
    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }
    public Fach getFach() {
        return fach;
    }
    public void setFach(Fach fachname) {
        this.fach = fach;
    }

}
