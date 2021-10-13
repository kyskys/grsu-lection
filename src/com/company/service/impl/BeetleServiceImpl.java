package com.company.service.impl;

import com.company.dao.api.BeetleDao;
import com.company.model.Beetle;
import com.company.service.api.BeetleService;

import java.util.List;

public class BeetleServiceImpl extends AbstractService<Beetle, BeetleDao> implements BeetleService {

    private BeetleDao beetleDao;

    public BeetleServiceImpl(BeetleDao beetleDao) {
        super(beetleDao);
        this.beetleDao = beetleDao;
    }

    @Override
    public List<Beetle> getAllSortedBy(String columnName) {
        if ("name".equals(columnName)) {
            return beetleDao.getAllSortedByName();
        } else if ("legsCount".equals(columnName)) {
            return beetleDao.getAllSortedByLegsCount();
        } else if ("color".equals(columnName)) {
            return beetleDao.getAllSortedByColor();
        }

        return null;
    }
}
