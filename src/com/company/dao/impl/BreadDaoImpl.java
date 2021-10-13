package com.company.dao.impl;

import com.company.dao.api.BreadDao;
import com.company.model.Bread;

public class BreadDaoImpl extends AbstractDao<Bread> implements BreadDao {

    private static BreadDaoImpl INSTANCE;

    private BreadDaoImpl() {

    }

    public static BreadDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BreadDaoImpl();
        }
        return INSTANCE;
    }
}
