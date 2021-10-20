package facade;


import grsu.lection.model.Bread;
import grsu.lection.model.Frenchman;
import grsu.lection.service.api.BreadService;
import grsu.lection.service.api.FrenchmanService;

import java.util.List;

public class ApplicationFacadeImpl implements ApplicationFacade {

    private final BreadService breadService;
    private final FrenchmanService frenchmanService;

    public ApplicationFacadeImpl(BreadService breadService, FrenchmanService frenchmanService) {
        this.breadService = breadService;
        this.frenchmanService = frenchmanService;
    }

    @Override
    public void saveBread(Bread entity) {
        breadService.save(entity);
    }

    @Override
    public void updateBread(Long id, Bread newEntity) {
        breadService.update(id, newEntity);
    }

    @Override
    public void deleteBread(Long id) {

    }

    @Override
    public Bread getById(Long id) {
        return null;
    }

    @Override
    public List<Bread> getAllBread() {
        return null;
    }

    @Override
    public List<Bread> getAllBreadSortedBy(String name) {
        return null;
    }

    @Override
    public void saveFrenchman(Frenchman entity) {

    }

    @Override
    public void updateFrenchman(Long id, Frenchman newEntity) {

    }

    @Override
    public void deleteFrenchman(Long id) {

    }

    @Override
    public Bread getByIdFrenchman(Long id) {
        return null;
    }

    @Override
    public List<Bread> getAllFrenchman() {
        return null;
    }

    @Override
    public String stompBeetle(Long frenchId, Long beetleId) {
        return null;
    }

    @Override
    public String eatBread(Long frenchId, Long breadId) {
        return null;
    }
}
