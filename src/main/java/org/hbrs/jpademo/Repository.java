package org.hbrs.jpademo;

import jakarta.persistence.*;

import java.util.List;

public class Repository<T> {

    private final EntityManagerFactory emf;

    private final Class<T> type;

    public Repository(Class<T> type) {
        this.type = type;
        this.emf = Persistence.createEntityManagerFactory("jpademo");
    }

    /**
     * Alle Datensätze der Entität mit einer gewissen Eigenschaft finden.
     * ACHTUNG: Diese Methode ist lediglich eine Testmethode und anfällig für SQL-Injections wegen "fieldname"!
     * Deswegen sollte diese Methode nicht in produktiven Anwendungen verwendet werden und ist auf private gesetzt.
     * @param fieldName Name des Feldes
     * @param value Wert des Feldes
     * @return Liste der Datensätze
     */
    private List<T> findByField(String fieldName, Object value) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM " + type.getSimpleName() + " e WHERE e." + fieldName + " = :value";
        TypedQuery<T> query = em.createQuery(jpql, type);
        query.setParameter("value", value);
        return query.getResultList();
    }

    /**
     * Alle Datensätze der Entität finden
     * @return Liste aller Datensätze
     */
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT e FROM " + type.getSimpleName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, type);
        return query.getResultList();
    }

    /**
     * Datensatz mit einer bestimmten ID aus Entität finden
     * @param id ID des Datensatzes
     * @return Datensatz
     */
    public T findById(Object id) {
        EntityManager em = emf.createEntityManager();
        return em.find(type, id);
    }

    /**
     * Komplexeres Beispiel für eine JPQL-Query (Schüler einer Klasse finden)
     * @param klasse Name der Klasse
     * @return Liste der Schüler
     */
    public List<T> findSchuelerFromKlasse(String klasse) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT s FROM Schueler s WHERE s.klasse.klassenname = :klasse";
        TypedQuery<T> query = em.createQuery(jpql, type);
        query.setParameter("klasse", klasse);
        return query.getResultList();
    }

    /**
     * Zweites komplexeres Beispiel für eine JPQL-Query (Adresse eines Lehrers finden)
     * @param id ID des Lehrers
     * @return Adresse des Lehrers
     */
    public T findLehrerAdresse(int id) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT a FROM Adresse a WHERE a.adresseId = (SELECT p.adresse.adresseId FROM Person p WHERE p.personId = :id)";
        TypedQuery<T> query = em.createQuery(jpql, type);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Datensatz speichern
     * @param entity Datensatz
     */
    public void save(T entity) {
        EntityManager em = emf.createEntityManager();
        if (em.contains(entity)) {
            em.merge(entity);
        } else {
            em.persist(entity);
        }
    }
}