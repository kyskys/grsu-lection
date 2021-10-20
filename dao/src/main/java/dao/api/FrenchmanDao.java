package dao.api;


import grsu.lection.model.Frenchman;

public interface FrenchmanDao extends Dao<Frenchman> {

    String frenchSaysBread(Long idFrenchman, Long idBread);

}
