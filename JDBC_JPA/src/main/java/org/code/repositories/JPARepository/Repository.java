package org.code.repositories.JPARepository;

import org.code.repositories.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

public class Repository<Entity, IDType extends Serializable> implements IRepository<Entity, IDType> {

    private final Class<Entity> entityClass;
    private final Class<IDType> idTypeClass;
    protected final EntityManager em;

    public Repository(Class<Entity> entityClass, Class<IDType> idTypeClass, EntityManager em) {
        this.entityClass = entityClass;
        this.idTypeClass = idTypeClass;
        this.em = em;
    }

    @Override
    public Entity save(Entity entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Entity findById(IDType id) throws Exception {
        Entity entity = em
                .find(entityClass, id);
        if (entity == null)
            throw new NoResultException("\n\n[!!!ERROR!!!]\n" + this.entityClass.getSimpleName() + " with ID " + id + " not found \n\n");
        return entity;
    }

    @Override
    public Iterable<Entity> findAll() {
        return em
                .createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    @Override
    public void deleteById(IDType id) throws Exception {
        Entity entity = findById(id);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() throws Exception {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar todos los registros de " + entityClass.getSimpleName());
        }

    }


    public Class<Entity> getEntityClass() {
        return entityClass;
    }

    public Class<IDType> getIdTypeClass() {
        return idTypeClass;
    }
}
