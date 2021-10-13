package com.company.dao.impl;

import com.company.dao.api.BeetleDao;
import com.company.model.Beetle;

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
}
