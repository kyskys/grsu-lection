package grsu.lection.dao.impl;

import grsu.lection.dao.api.BeetleDao;
import grsu.lection.dao.comparator.BeetleColorComparator;
import grsu.lection.dao.comparator.BeetleLegsCountComparator;
import grsu.lection.dao.comparator.BeetleNameComparator;
import grsu.lection.model.Beetle;
import grsu.lection.model.Beetle_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        return getAllSortedBy(new BeetleColorComparator());
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
    protected Class<Beetle> getEntityClass() {
        return Beetle.class;
    }
}
