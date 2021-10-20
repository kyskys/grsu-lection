package grsu.lection.service.impl;

import dao.api.BeetleDao;
import dao.api.BreadDao;
import dao.api.FrenchmanDao;
import grsu.lection.model.Beetle;
import grsu.lection.model.Bread;
import grsu.lection.model.Frenchman;
import grsu.lection.service.api.FrenchmanService;

import java.time.LocalDate;
import java.util.List;

public class FrenchmanServiceImpl extends AbstractService<Frenchman, FrenchmanDao> implements FrenchmanService {

    private final FrenchmanDao frenchmanDao;
    private final BeetleDao beetleDao;
    private final BreadDao breadDao;

    public FrenchmanServiceImpl(FrenchmanDao frenchmanDao, BeetleDao beetleDao, BreadDao breadDao) {
        super(frenchmanDao);
        this.frenchmanDao = frenchmanDao;
        this.beetleDao = beetleDao;
        this.breadDao = breadDao;
    }

    @Override
    public List<Frenchman> getAllSortedBy(String name) {
        return null;
    }

    @Override
    public String stompBeetle(Long frenchId, Long beetleId) {
        Frenchman frenchman = frenchmanDao.getById(frenchId);
        Beetle beetle = beetleDao.getById(beetleId);

        if (5 < beetle.getLegsCount()) {
            return "Французик " + frenchman.getName() + " испугался жука " + beetle.getName() + "!";
        } else {
            beetleDao.delete(beetleId);
            return  "Французик " + frenchman.getName() + " задавил жука " + beetle.getName() + "! Press F";
        }

    }

    @Override
    public String eatBread(Long frenchId, Long breadId) {
        Frenchman frenchman = frenchmanDao.getById(frenchId);
        Bread bread = breadDao.getById(breadId);

        LocalDate expireDate = bread.getCreationDate().plusDays(bread.getAliveDays());
        LocalDate now = LocalDate.now();
        if (expireDate.isBefore(now)) {
                return "Французик " + frenchman.getName() + " показал, что не скушал " +
                        (frenchman.isMime() ? "(\\\\\\\\\\)" : "хлеб") +
                        " , потому что он просрочен!";
        } else {
            breadDao.delete(breadId);
            return "Французик " + frenchman.getName() + " скушал хлеб!";
        }
    }
}