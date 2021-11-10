package grsu.lection.service.impl;

import grsu.lection.dao.api.BeetleDao;
import grsu.lection.dao.api.BreadDao;
import grsu.lection.dao.api.FrenchmanDao;
import grsu.lection.model.Beetle;
import grsu.lection.model.Bread;
import grsu.lection.model.Frenchman;
import grsu.lection.service.api.FrenchmanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FrenchmanServiceImpl implements FrenchmanService {
    @Override
    public String stompBeetle(Long frenchId, Long beetleId) {
        return null;
    }

    @Override
    public String eatBread(Long frenchId, Long breadId) {
        return null;
    }
//
//    private final FrenchmanDao frenchmanDao;
//    private final BeetleDao beetleDao;
//    private final BreadDao breadDao;
//
//    @Override
//    protected FrenchmanDao getDefaultDao() {
//        return null;
//    }
//
//    @Override
//    public List<Frenchman> getAllSortedBy(String name) {
//        return null;
//    }
//
//    @Override
//    public String stompBeetle(Long frenchId, Long beetleId) {
//        Frenchman frenchman = frenchmanDao.getById(frenchId);
//        Beetle beetle = beetleDao.getById(beetleId);
//
//        if (5 < beetle.getLegsCount()) {
//            return "Французик " + frenchman.getName() + " испугался жука " + beetle.getName() + "!";
//        } else {
//            beetleDao.delete(beetleId);
//            return  "Французик " + frenchman.getName() + " задавил жука " + beetle.getName() + "! Press F";
//        }
//
//    }
//
//    @Override
//    public String eatBread(Long frenchId, Long breadId) {
//        Frenchman frenchman = frenchmanDao.getById(frenchId);
//        Bread bread = breadDao.getById(breadId);
//
//        LocalDate expireDate = bread.getCreationDate().plusDays(bread.getAliveDays());
//        LocalDate now = LocalDate.now();
//        if (expireDate.isBefore(now)) {
//                return "Французик " + frenchman.getName() + " показал, что не скушал " +
//                        (frenchman.isMime() ? "(\\\\\\\\\\)" : "хлеб") +
//                        " , потому что он просрочен!";
//        } else {
//            breadDao.delete(breadId);
//            return "Французик " + frenchman.getName() + " скушал хлеб!";
//        }
//    }
}
