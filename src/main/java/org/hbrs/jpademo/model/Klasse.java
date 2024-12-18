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

    @ManyToMany(mappedBy = "klassen")
    private List<Lehrer> lehrer;

    @ManyToMany
    @JoinTable(name = "hat_faecher",
        joinColumns = @JoinColumn(name ="klasse_id"),
        inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<Fach> faecher;

    @OneToOne
    private Lehrer klassenlehrer;

    @OneToMany(mappedBy = "klasse")
    private List<Schueler> schueler;

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

    public List<Lehrer> getLehrer() {
        return lehrer;
    }

    public void setLehrer(List<Lehrer> lehrer) {
        this.lehrer = lehrer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klasse that = (Klasse) o;
        return klassenId == that.klassenId && Objects.equals(klassenname, that.klassenname) && Objects.equals(lehrer, that.lehrer) && Objects.equals(faecher, that.faecher) && Objects.equals(klassenlehrer, that.klassenlehrer) && Objects.equals(schueler, that.schueler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klassenId, klassenname, lehrer, faecher, klassenlehrer, schueler);
    }
}
