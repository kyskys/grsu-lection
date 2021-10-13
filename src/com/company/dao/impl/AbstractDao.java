package com.company.dao.impl;

import com.company.dao.api.Dao;
import com.company.model.AbstractEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity<T>> implements Dao<T> {

    private List<T> repository = new ArrayList<>();
    private long sequence = 0;

    @Override
    public void save(T entity) {
        entity.setId(sequence);
        sequence++;
        repository.add(entity);
    }

    @Override
    public void update(Long id, T newEntity) {
        T oldEntity = findInRepository(id);
        oldEntity.update(newEntity);
    }

    @Override
    public void delete(Long id) {
        T existEntity = findInRepository(id);
        repository.remove(existEntity);
    }

    @Override
    public T getById(Long id) {
        return findInRepository(id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        List<T> toSort = getAll();
        toSort.sort(comparator);
        return toSort;
    }

    private T findInRepository(Long id) {
        for (T obj : repository) {
            if (obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }
}
