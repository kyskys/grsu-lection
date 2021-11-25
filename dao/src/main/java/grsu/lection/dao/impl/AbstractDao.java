package grsu.lection.dao.impl;

import grsu.lection.dao.api.Dao;
import grsu.lection.dao.exception.EntityNotFoundException;
import grsu.lection.model.AbstractEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {

    @PersistenceContext
    @Getter(AccessLevel.PROTECTED)
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Override
    public void save(T entity) {
        log.info("Выполняю метод save, обьект=" + entity);
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        log.info("Выполняю метод update, обьект=" + entity);
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        log.info("Выполняю метод delete");
        log.debug("Выполняю метод delete, id = " + id);
        String queryString = "delete from " + getEntityClass().getName() + " ent where ent.id = :id";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public T getById(Long id) {
        log.info("Выполняю метод get, id = " + id);
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> getAll() {
        log.info("Выполняю метод getAll");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        log.info("Выполняю метод getAllSortedBy, компаратор + " + comparator.getClass());
        List<T> toSort = getAll();
        toSort.sort(comparator);
        return toSort;
    }
}
