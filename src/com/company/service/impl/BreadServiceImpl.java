package com.company.service.impl;

import com.company.dao.api.BreadDao;
import com.company.model.Bread;
import com.company.service.api.BreadService;

import java.util.List;

public class BreadServiceImpl extends AbstractService<Bread, BreadDao> implements BreadService {

    private BreadDao breadDao;

    public BreadServiceImpl(BreadDao breadDao) {
        super(breadDao);
        this.breadDao = breadDao;
    }

    @Override
    public List<Bread> getAllSortedBy(String name) {
        return null;
    }
}
