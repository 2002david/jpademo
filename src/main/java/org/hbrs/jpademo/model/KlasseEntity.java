package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "klasse", schema = "public", catalog = "dstegl2s")
public class KlasseEntity {
    @Id
    @Basic
    @Column(name = "klassenname")
    private String klassenname;
    @Basic
    @Column(name = "klassenlehrer")
    private Integer klassenlehrer;

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
