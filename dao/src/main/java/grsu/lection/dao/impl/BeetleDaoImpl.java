package grsu.lection.dao.impl;

import grsu.lection.dao.api.BeetleDao;
import grsu.lection.dao.comparator.BeetleColorComparator;
import grsu.lection.dao.comparator.BeetleLegsCountComparator;
import grsu.lection.dao.comparator.BeetleNameComparator;
import grsu.lection.model.Beetle;
import org.springframework.stereotype.Repository;

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
    protected Class<Beetle> getEntityClass() {
        return Beetle.class;
    }
}
