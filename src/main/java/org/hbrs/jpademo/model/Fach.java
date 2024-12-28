package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Fach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int fachId;

    private String fachname;

    @ManyToMany(mappedBy = "faecher")
    private List<Lehrer> lehrer;

    @ManyToMany(mappedBy="faecher")
    private List<Klasse> klassen;

    @OneToMany(mappedBy = "fach")
    private List<Unterrichtet_Klasse> unterrichtet_in_klassen;

    public int getFachId() {
        return fachId;
    }

    public void setFachId(int fachId) {
        this.fachId = fachId;
    }

    public String getFachname() {
        return fachname;
    }

    public void setFachname(String fachname) {
        this.fachname = fachname;
    }

    public List<Lehrer> getLehrer() {
        return lehrer;
    }

    public void setLehrer(List<Lehrer> lehrer) {
        this.lehrer = lehrer;
    }

    public List<Klasse> getKlassen() {
        return klassen;
    }

    public void setKlassen(List<Klasse> klassen) {
        this.klassen = klassen;
    }

    public List<Unterrichtet_Klasse> getUnterrichtet_in_klassen() {
        return unterrichtet_in_klassen;
    }

    public void setUnterrichtet_in_klassen(List<Unterrichtet_Klasse> unterrichtet_in_klassen) {
        this.unterrichtet_in_klassen = unterrichtet_in_klassen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fach fach = (Fach) o;
        return fachId == fach.fachId && Objects.equals(fachname, fach.fachname) && Objects.equals(lehrer, fach.lehrer) && Objects.equals(klassen, fach.klassen) && Objects.equals(unterrichtet_in_klassen, fach.unterrichtet_in_klassen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fachId, fachname, lehrer, klassen, unterrichtet_in_klassen);
    }
}
