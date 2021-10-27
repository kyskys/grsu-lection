package grsu.lection.dao.impl;


import grsu.lection.dao.api.BreadDao;
import grsu.lection.model.Bread;
import org.springframework.stereotype.Repository;

@Repository
public class BreadDaoImpl extends AbstractDao<Bread> implements BreadDao {

    @Override
    protected Class<Bread> getEntityClass() {
        return Bread.class;
    }
}
