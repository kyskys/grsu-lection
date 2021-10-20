package grsu.lection.service.impl;

import dao.api.BreadDao;
import grsu.lection.model.Bread;
import grsu.lection.service.api.BreadService;

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
