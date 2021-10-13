package com.company.dao.api;

import com.company.model.Frenchman;

public interface FrenchmanDao extends Dao<Frenchman> {

    String frenchSaysBread(Long idFrenchman, Long idBread);

}
