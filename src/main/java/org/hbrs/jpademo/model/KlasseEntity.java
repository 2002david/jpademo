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

    @Column(name = "klassenlehrer")
    private Integer klassenlehrer;

    @OneToOne
    private LehrerEntity lehrer;

    @OneToMany(mappedBy = "klasse")
    private List<SchuelerEntity> schueler;

    public String getKlassenname() {
        return klassenname;
    }

    public void setKlassenname(String klassenname) {
        this.klassenname = klassenname;
    }

    public Integer getKlassenlehrer() {
        return klassenlehrer;
    }

    public void setKlassenlehrer(Integer klassenlehrer) {
        this.klassenlehrer = klassenlehrer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlasseEntity that = (KlasseEntity) o;
        return Objects.equals(klassenname, that.klassenname) && Objects.equals(klassenlehrer, that.klassenlehrer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klassenname, klassenlehrer);
    }
}
