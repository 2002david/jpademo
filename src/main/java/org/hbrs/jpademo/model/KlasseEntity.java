package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "klasse", schema = "public", catalog = "dstegl2s")
public class KlasseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int klassenId;

    @Column(name = "klassenname")
    private String klassenname;


    @ManyToMany(mappedBy = "klassen")
    @Column(name="lehrer")
    private List<LehrerEntity> lehrer;

    @ManyToMany
    @Column(name = "faecher")
    @JoinTable(name = "hat_faecher",
        joinColumns = @JoinColumn(name ="klasse_id"),
        inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<FachEntity> faecher;

    @OneToOne
    private LehrerEntity klassenlehrer;

    @OneToMany(mappedBy = "klasse")
    private List<SchuelerEntity> schueler;

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

    public List<LehrerEntity> getLehrer() {
        return lehrer;
    }

    public void setLehrer(List<LehrerEntity> lehrer) {
        this.lehrer = lehrer;
    }

    public List<FachEntity> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<FachEntity> faecher) {
        this.faecher = faecher;
    }

    public LehrerEntity getKlassenlehrer() {
        return klassenlehrer;
    }

    public void setKlassenlehrer(LehrerEntity klassenlehrer) {
        this.klassenlehrer = klassenlehrer;
    }

    public List<SchuelerEntity> getSchueler() {
        return schueler;
    }

    public void setSchueler(List<SchuelerEntity> schueler) {
        this.schueler = schueler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlasseEntity that = (KlasseEntity) o;
        return klassenId == that.klassenId && Objects.equals(klassenname, that.klassenname) && Objects.equals(lehrer, that.lehrer) && Objects.equals(faecher, that.faecher) && Objects.equals(klassenlehrer, that.klassenlehrer) && Objects.equals(schueler, that.schueler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klassenId, klassenname, lehrer, faecher, klassenlehrer, schueler);
    }
}
