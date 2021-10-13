package com.company.service.impl;

import com.company.dao.api.Dao;
import com.company.dao.impl.AbstractDao;
import com.company.model.AbstractEntity;
import com.company.service.api.Service;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity<T>, D extends Dao<T>> implements Service<T> {

    private final D defaultDao;

    protected AbstractService(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public void save(T entity) {
        defaultDao.save(entity);
    }

    @Override
    public void update(Long id, T newEntity) {
        defaultDao.update(id, newEntity);
    }

    @Override
    public void delete(Long id) {
        defaultDao.delete(id);
    }

    @Override
    public T getById(Long id) {
        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }
}
