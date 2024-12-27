package org.hbrs.jpademo.model;

import jakarta.persistence.*;

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

    private String fachname;

    public Unterrichtet_Klasse() {}

    public Unterrichtet_Klasse(Lehrer lehrer, Klasse klasse, String fachname) {
        this.lehrer = lehrer;
        this.klasse = klasse;
        this.fachname = fachname;
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
    public String getFachname() {
        return fachname;
    }
    public void setFachname(String fachname) {
        this.fachname = fachname;
    }

}
