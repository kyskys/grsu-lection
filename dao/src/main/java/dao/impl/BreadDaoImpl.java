package dao.impl;


import dao.api.BreadDao;
import grsu.lection.model.Bread;

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
