package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adresse", schema = "public", catalog = "dstegl2s")
public class AdresseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public List<PersonEntity> getPersonId() {
        return personId;
    }

    public void setPersonId(List<PersonEntity> personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseEntity adresse = (AdresseEntity) o;
        return adresseId == adresse.adresseId && Objects.equals(strasse, adresse.strasse) && Objects.equals(hausnr, adresse.hausnr) && Objects.equals(plz, adresse.plz) && Objects.equals(ort, adresse.ort) && Objects.equals(personId, adresse.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresseId, strasse, hausnr, plz, ort, personId);
    }
}
