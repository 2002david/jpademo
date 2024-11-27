package org.hbrs.jpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "unterrichtet", schema = "public", catalog = "dstegl2s")
public class UnterrichtetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "lehrer")
    private int lehrer;

    public int getLehrer() {
        return lehrer;
    }

    public void setLehrer(int lehrer) {
        this.lehrer = lehrer;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "fach")
    private int fach;

    public int getFach() {
        return fach;
    }

    public void setFach(int fach) {
        this.fach = fach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnterrichtetEntity that = (UnterrichtetEntity) o;
        return lehrer == that.lehrer && fach == that.fach;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lehrer, fach);
    }
}
