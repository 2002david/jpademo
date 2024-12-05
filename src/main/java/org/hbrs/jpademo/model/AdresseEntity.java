package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adresse", schema = "public", catalog = "dstegl2s")
public class AdresseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private int adresseId;

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "hausnr")
    private String hausnr;

    @Column(name = "plz")
    private String plz;

    @Column(name = "ort")
    private String ort;

    @OneToMany(mappedBy = "personId")
    private List<PersonEntity> personId;

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnr() {
        return hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseEntity that = (AdresseEntity) o;
        return adresseId == that.adresseId && Objects.equals(strasse, that.strasse) && Objects.equals(hausnr, that.hausnr) && Objects.equals(plz, that.plz) && Objects.equals(ort, that.ort) && Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresseId, strasse, hausnr, plz, ort, personId);
    }
}
