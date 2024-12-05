package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lehrer", schema = "public", catalog = "dstegl2s")
public class LehrerEntity {

    @Id
    @OneToOne
    private PersonEntity person;

    @Column(name = "gehalt")
    private Double gehalt;

    @OneToOne
    private KlasseEntity klasse;

    @ManyToMany
    @Column(name = "faecher")
    @JoinTable(name = "unterrichtet_fach",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "fach_id"))
    private List<FachEntity> faecher;
    @ManyToMany
    @Column(name = "klasse")
    @JoinTable(name = "unterrichtet_klassen",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "klasse_id"))
    private List<KlasseEntity> klassen;


    public Double getGehalt() {
        return gehalt;
    }

    public void setGehalt(Double gehalt) {
        this.gehalt = gehalt;
    }

}
