package com.company.service.impl;

import com.company.dao.api.FrenchmanDao;
import com.company.model.Frenchman;
import com.company.service.api.FrenchmanService;

import java.util.List;

public class FrenchmanServiceImpl extends AbstractService<Frenchman, FrenchmanDao> implements FrenchmanService {

    public FrenchmanServiceImpl(FrenchmanDao frenchmanDao) {
        super(frenchmanDao);
    }

    @Override
    public List<Frenchman> getAllSortedBy(String name) {
        return null;
    }
}
