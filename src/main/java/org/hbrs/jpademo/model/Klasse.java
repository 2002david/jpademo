package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Klasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int klassenId;

    private String klassenname;

    @ManyToMany
    @JoinTable(name = "hat_faecher",
        joinColumns = @JoinColumn(name ="klasse_id"),
        inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<Fach> faecher;

    @OneToOne
    private Lehrer klassenlehrer;

    @OneToMany(mappedBy = "klasse")
    private List<Schueler> schueler;

    @OneToMany(mappedBy = "klasse")
    private List<Unterrichtet_Klasse> unterrichtet_von;

    public int getKlassenId() {
        return klassenId;
    }

    public void setKlassenId(int klassenId) {
        this.klassenId = klassenId;
    }

    public String getKlassenname() {
        return klassenname;
    }

    public void setKlassenname(String klassenname) {
        this.klassenname = klassenname;
    }

    public List<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<Fach> faecher) {
        this.faecher = faecher;
    }

    public Lehrer getKlassenlehrer() {
        return klassenlehrer;
    }

    public void setKlassenlehrer(Lehrer klassenlehrer) {
        this.klassenlehrer = klassenlehrer;
    }

    public List<Schueler> getSchueler() {
        return schueler;
    }

    public void setSchueler(List<Schueler> schueler) {
        this.schueler = schueler;
    }

    public List<Unterrichtet_Klasse> getUnterrichtet_von() {
        return unterrichtet_von;
    }

    public void setUnterrichtet_von(List<Unterrichtet_Klasse> unterrichtet_von) {
        this.unterrichtet_von = unterrichtet_von;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klasse klasse = (Klasse) o;
        return klassenId == klasse.klassenId && Objects.equals(klassenname, klasse.klassenname) && Objects.equals(faecher, klasse.faecher) && Objects.equals(klassenlehrer, klasse.klassenlehrer) && Objects.equals(schueler, klasse.schueler) && Objects.equals(unterrichtet_von, klasse.unterrichtet_von);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klassenId, klassenname, faecher, klassenlehrer, schueler, unterrichtet_von);
    }
}
