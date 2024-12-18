package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int adresseId;

    private String strasse;

    private String hausnr;

    private String plz;

    private String ort;

    @OneToMany(mappedBy = "personId")
    private List<Person> personId;

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

    public List<Person> getPersonId() {
        return personId;
    }

    public void setPersonId(List<Person> personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return adresseId == adresse.adresseId && Objects.equals(strasse, adresse.strasse) && Objects.equals(hausnr, adresse.hausnr) && Objects.equals(plz, adresse.plz) && Objects.equals(ort, adresse.ort) && Objects.equals(personId, adresse.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresseId, strasse, hausnr, plz, ort, personId);
    }
}
