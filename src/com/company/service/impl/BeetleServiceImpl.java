package com.company.service.impl;

import com.company.dao.api.BeetleDao;
import com.company.model.Beetle;
import com.company.service.api.BeetleService;

public class BeetleServiceImpl extends AbstractService<Beetle, BeetleDao> implements BeetleService {

    public BeetleServiceImpl(BeetleDao beetleDao) {
        super(beetleDao);
    }

}
