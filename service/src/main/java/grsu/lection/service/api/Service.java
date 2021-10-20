package grsu.lection.service.api;

import grsu.lection.model.AbstractEntity;

import java.util.List;

public interface Service<T extends AbstractEntity<T>> {
    void save(T entity);
    void update(Long id, T newEntity);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
    List<T> getAllSortedBy(String name);
}
