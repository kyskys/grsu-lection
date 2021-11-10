package grsu.lection.dao.impl;

import grsu.lection.dao.api.BakeryDao;
import grsu.lection.model.Bakery;
import org.springframework.stereotype.Repository;

@Repository
public class BakeryDaoImpl extends AbstractDao<Bakery> implements BakeryDao {

    @Override
    protected Class<Bakery> getEntityClass() {
        return Bakery.class;
    }
}
