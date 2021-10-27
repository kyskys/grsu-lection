package grsu.lection.service.impl;


import grsu.lection.dao.api.Dao;
import grsu.lection.model.AbstractEntity;
import grsu.lection.service.api.Service;

import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, D extends Dao<T>> implements Service<T> {

    protected abstract D getDefaultDao();

    @Transactional
    @Override
    public void save(T entity) {
        getDefaultDao().save(entity);
    }

    @Transactional
    @Override
    public void update(T entity) {
        getDefaultDao().update(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }

    @Override
    public T getById(Long id) {
        return getDefaultDao().getById(id);
    }

    @Override
    public List<T> getAll() {
        return getDefaultDao().getAll();
    }
}
