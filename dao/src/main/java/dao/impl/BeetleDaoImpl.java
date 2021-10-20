package dao.impl;

import dao.api.BeetleDao;
import dao.comparator.BeetleColorComparator;
import dao.comparator.BeetleLegsCountComparator;
import dao.comparator.BeetleNameComparator;
import grsu.lection.model.Beetle;

import java.util.List;

public class BeetleDaoImpl extends AbstractDao<Beetle> implements BeetleDao {
    private static BeetleDao INSTANCE;

    private BeetleDaoImpl() {

    }

    public static BeetleDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BeetleDaoImpl();
        }
        return INSTANCE;
    }

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
}
