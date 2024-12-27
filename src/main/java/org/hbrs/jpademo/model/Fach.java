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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fach that = (Fach) o;
        return fachId == that.fachId && Objects.equals(fachname, that.fachname) && Objects.equals(lehrer, that.lehrer) && Objects.equals(klassen, that.klassen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fachId, fachname, lehrer, klassen);
    }
}
