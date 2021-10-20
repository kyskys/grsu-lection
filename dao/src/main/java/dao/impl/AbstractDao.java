package dao.impl;

import dao.api.Dao;
import dao.exception.EntityNotFoundException;
import grsu.lection.model.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public abstract class AbstractDao<T extends AbstractEntity<T>> implements Dao<T> {

    private List<T> repository = new ArrayList<>();
    private long sequence = 0;

    @Override
    public void save(T entity) {
        entity.setId(sequence);
        sequence++;
        log.info("Выполняю метод save, обьект=" + entity + "sequence = " + sequence);
        repository.add(entity);
    }

    @Override
    public void update(Long id, T newEntity) {
        log.info("Выполняю метод update, id = " + id + ", обьект=" + newEntity);
        T oldEntity = getById(id);
        oldEntity.update(newEntity);
    }

    @Override
    public void delete(Long id) {
        log.info("Выполняю метод delete");
        log.debug("Выполняю метод delete, id = " + id);
        T existEntity = getById(id);
        repository.remove(existEntity);
    }

    @Override
    public T getById(Long id) {
        log.info("Выполняю метод get, id = " + id);
        return repository
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<T> getAll() {
        log.info("Выполняю метод getAll");
        return new ArrayList<>(repository);
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        log.info("Выполняю метод getAllSortedBy, компаратор + " + comparator.getClass());
        List<T> toSort = getAll();
        toSort.sort(comparator);
        return toSort;
    }
}
