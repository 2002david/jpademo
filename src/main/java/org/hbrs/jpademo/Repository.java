package org.hbrs.jpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class Repository<T> {

    @PersistenceContext
    private EntityManager em;

    private final Class<T> entityType;

    public Repository(Class<T> entityType) {
        this.entityType = entityType;
    }

    /**
     * Alle Datensätze der Entität mit einer gewissen Eigenschaft finden.
     * @param fieldName Name des Feldes
     * @param value Wert des Feldes
     * @return Liste der Datensätze
     */
    public List<T> findByField(String fieldName, Object value) {
        String jpql = "SELECT e FROM " + entityType.getSimpleName() + " e WHERE e." + fieldName + " = :value"; //TODO SQL Injection fix
        TypedQuery<T> query = em.createQuery(jpql, entityType);
        query.setParameter("value", value);
        return query.getResultList();
    }

    /**
     * Alle Datensätze der Entität finden
     * @return Liste aller Datensätze
     */
    public List<T> findAll() {
        String jpql = "SELECT e FROM " + entityType.getSimpleName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, entityType);
        return query.getResultList();
    }

    /**
     * Datensatz mit einer bestimmten ID aus Entität finden
     * @param id ID des Datensatzes
     * @return Datensatz
     */
    public T findById(Object id) {
        return em.find(entityType, id);
    }

    /**
     * Komplexeres Beispiel für eine JPQL-Query (Adresse eines Lehrers finden)
     * @param id ID des Lehrers
     */
    public T findLehrerAdresse(int id) {
        String jpql = "SELECT a FROM Adresse a WHERE a.adresseId.personId = :id";
        TypedQuery<T> query = em.createQuery(jpql, entityType);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Datensatz speichern
     * @param entity Datensatz
     */
    public void save(T entity) {
        if (em.contains(entity)) {
            em.merge(entity);
        } else {
            em.persist(entity);
        }
    }


}