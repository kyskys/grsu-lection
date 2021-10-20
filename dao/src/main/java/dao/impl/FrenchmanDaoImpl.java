package dao.impl;


import dao.api.FrenchmanDao;
import grsu.lection.model.Frenchman;

public class FrenchmanDaoImpl extends AbstractDao<Frenchman> implements FrenchmanDao {

    private static FrenchmanDaoImpl INSTANCE;

    private FrenchmanDaoImpl() {

    }

    public static FrenchmanDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FrenchmanDaoImpl();
        }
        return INSTANCE;
    }

    @Override
    public String frenchSaysBread(Long idFrenchman, Long idBread) {
        Frenchman frenchman = getById(idFrenchman);
        return null;
    }
}
