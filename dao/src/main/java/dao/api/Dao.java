package dao.api;

import grsu.lection.model.AbstractEntity;

import java.util.Comparator;
import java.util.List;

public interface Dao<T extends AbstractEntity> {
    void save(T entity);
    void update(Long id, T newEntity);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
    List<T> getAllSortedBy(Comparator<T> comparator);
}
