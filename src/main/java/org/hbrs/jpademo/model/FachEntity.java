package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fach", schema = "public", catalog = "dstegl2s")
public class FachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int fachId;

    @Column(name = "fachname")
    private String fachname;

    @ManyToMany(mappedBy = "faecher")
    @Column(name = "lehrer")
    private List<LehrerEntity> lehrer;

    @ManyToMany(mappedBy="faecher")
    @Column(name="klassen")
    private List<KlasseEntity> klassen;

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

    public List<LehrerEntity> getLehrer() {
        return lehrer;
    }

    public void setLehrer(List<LehrerEntity> lehrer) {
        this.lehrer = lehrer;
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
        FachEntity that = (FachEntity) o;
        return fachId == that.fachId && Objects.equals(fachname, that.fachname) && Objects.equals(lehrer, that.lehrer) && Objects.equals(klassen, that.klassen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fachId, fachname, lehrer, klassen);
    }
}
