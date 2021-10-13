package com.company.dao.api;

import com.company.model.AbstractEntity;

import java.util.List;

public interface Dao<T extends AbstractEntity> {
    void save(T entity);
    void update(Long id, T newEntity);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
}
