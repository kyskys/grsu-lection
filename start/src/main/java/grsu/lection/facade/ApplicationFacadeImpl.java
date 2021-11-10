package grsu.lection.facade;


import grsu.lection.model.Bread;
import grsu.lection.model.Frenchman;
import grsu.lection.service.api.BreadService;
import grsu.lection.service.api.FrenchmanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ApplicationFacadeImpl implements ApplicationFacade {

    @Override
    public void saveBread(Bread entity) {
        //breadService.save(entity);
    }

    @Override
    public void updateBread(Bread newEntity) {
        //breadService.update(newEntity);
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
