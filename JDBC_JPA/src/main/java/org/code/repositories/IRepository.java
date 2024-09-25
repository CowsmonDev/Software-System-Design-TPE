package org.code.repositories;

import java.io.Serializable;

public interface IRepository <Entity, IDType extends Serializable> {

    Entity save(Entity entity);
    Entity findById(IDType id) throws Exception;
    Iterable<Entity> findAll();
    void deleteById(IDType id) throws Exception;

    void deleteAll() throws Exception;

}
