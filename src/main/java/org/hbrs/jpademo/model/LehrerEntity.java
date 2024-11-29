package org.hbrs.jpademo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "lehrer", schema = "public", catalog = "dstegl2s")
public class LehrerEntity {
    @Id
    @Column(name = "person_id")
    private int personId;
    @Column(name = "gehalt")
    private BigDecimal gehalt;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public BigDecimal getGehalt() {
        return gehalt;
    }

    public void setGehalt(BigDecimal gehalt) {
        this.gehalt = gehalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LehrerEntity that = (LehrerEntity) o;
        return personId == that.personId && Objects.equals(gehalt, that.gehalt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, gehalt);
    }
}
