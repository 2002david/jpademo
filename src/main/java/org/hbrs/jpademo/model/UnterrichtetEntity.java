package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "unterrichtet", schema = "public", catalog = "dstegl2s")
public class UnterrichtetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lehrer")
    private int lehrer;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fach")
    private int fach;

    public int getLehrer() {
        return lehrer;
    }

    public void setLehrer(int lehrer) {
        this.lehrer = lehrer;
    }

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
