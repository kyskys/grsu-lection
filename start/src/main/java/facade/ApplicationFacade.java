package facade;

import grsu.lection.model.Bread;
import grsu.lection.model.Frenchman;

import java.util.List;

public interface ApplicationFacade {
    // Bread methods
    void saveBread(Bread entity);
    void updateBread(Long id, Bread newEntity);
    void deleteBread(Long id);
    Bread getById(Long id);
    List<Bread> getAllBread();
    List<Bread> getAllBreadSortedBy(String name);

    //Frenchman methods
    void saveFrenchman(Frenchman entity);
    void updateFrenchman(Long id, Frenchman newEntity);
    void deleteFrenchman(Long id);
    Bread getByIdFrenchman(Long id);
    List<Bread> getAllFrenchman();
    String stompBeetle(Long frenchId, Long beetleId);
    String eatBread(Long frenchId, Long breadId);
}
