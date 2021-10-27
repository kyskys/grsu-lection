package grsu.lection.dao.impl;


import grsu.lection.dao.api.FrenchmanDao;
import grsu.lection.model.Frenchman;
import org.springframework.stereotype.Repository;

@Repository
public class FrenchmanDaoImpl extends AbstractDao<Frenchman> implements FrenchmanDao {

    @Override
    public String frenchSaysBread(Long idFrenchman, Long idBread) {
        Frenchman frenchman = getById(idFrenchman);
        return null;
    }

    @Override
    protected Class<Frenchman> getEntityClass() {
        return Frenchman.class;
    }
}
