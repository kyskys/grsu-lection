package com.company.dao.impl;

import com.company.dao.comparator.BeetleColorComparator;
import com.company.dao.comparator.BeetleLegsCountComparator;
import com.company.dao.comparator.BeetleNameComparator;
import com.company.dao.api.BeetleDao;
import com.company.model.Beetle;

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
