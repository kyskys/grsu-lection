package grsu.lection.service.api;

import grsu.lection.model.AbstractEntity;

import java.util.List;

public interface Service<T extends AbstractEntity> {
    void save(T entity);
    void update(T entity);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
    List<T> getAllSortedBy(String name);
}
