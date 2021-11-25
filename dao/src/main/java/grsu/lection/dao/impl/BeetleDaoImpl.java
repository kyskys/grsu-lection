package grsu.lection.dao.impl;

import grsu.lection.dao.api.BeetleDao;
import grsu.lection.dao.comparator.BeetleLegsCountComparator;
import grsu.lection.dao.comparator.BeetleNameComparator;
import grsu.lection.dao.filter.BeetleSearch;
import grsu.lection.dao.filter.OrderField;
import grsu.lection.dao.util.OrderEnum;
import grsu.lection.model.Bakery_;
import grsu.lection.model.Beetle;
import grsu.lection.model.Beetle_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BeetleDaoImpl extends AbstractDao<Beetle> implements BeetleDao {

    @Override
    public List<Beetle> getAllSortedByName() {
        return getAllSortedBy(new BeetleNameComparator());
    }

    @Override
    public List<Beetle> getAllSortedByLegsCount() {
        return getAllSortedBy(new BeetleLegsCountComparator());
    }

    @Override
    public List<Beetle> getAllSortedByColor() {
        return null;
    }

    @Override
    public List<Beetle> findAllByName(String name) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Beetle> query = builder.createQuery(Beetle.class);
        Root<Beetle> root = query.from(Beetle.class);
        query.where(builder.equal(root.get(Beetle_.NAME), name));
        return getEntityManager().createQuery(query).getResultList();
    }

    @Override
    public List<Beetle> search(Integer size, Integer page, BeetleSearch search) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Beetle> query = builder.createQuery(Beetle.class);
        Root<Beetle> root = query.from(Beetle.class);
        root.fetch(Beetle_.bakery);
        List<Predicate> predicates = new ArrayList<>();

        if (search.getId() != null) {
            predicates.add(builder.equal(root.get(Beetle_.id), search.getId()));
        }
        if (search.getName() != null) {
            predicates.add(builder.like(builder.lower(root.get(Beetle_.name)), getCriteriaLikeValue(search.getName())));
        }
        if (search.getLegsCount() != null) {
            predicates.add(builder.equal(root.get(Beetle_.legsCount), search.getLegsCount()));
        }
        if (search.getBakeryId() != null) {
            predicates.add(builder.equal(root.join(Beetle_.bakery).get(Bakery_.id), search.getBakeryId()));
        }

        if (!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[0]));

        }
        if (search.getOrder() != null) {
            OrderField order = search.getOrder();
            SingularAttribute attr = getAttributeFromString(order.getField());
            query.orderBy(OrderEnum.isDesc(order.getOrder()) ? builder.desc(root.get(attr)) : builder.asc(root.get(attr)));
        }
        return getEntityManager().createQuery(query).setFirstResult(size * page).setMaxResults(size).getResultList();
    }

    @Override
    protected Class<Beetle> getEntityClass() {
        return Beetle.class;
    }

    private SingularAttribute getAttributeFromString(String attr) {
        if ("id".equals(attr)) {
            return Beetle_.id;
        } else if ("name".equals(attr)) {
            return Beetle_.name;
        } else if ("legsCount".equals(attr)) {
            return Beetle_.legsCount;
        } else if ("color".equals(attr)) {
            return Beetle_.color;
        } else if ("bakery".equals(attr)) {
            return Beetle_.bakery;
        } else {
            return Beetle_.id;
        }
    }

    private String getCriteriaLikeValue(String value) {
        return "%" + value.toLowerCase() + "%";
    }
}
