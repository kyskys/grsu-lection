package com.company.service.impl;

import com.company.dao.api.BeetleDao;
import com.company.dao.api.BreadDao;
import com.company.model.Beetle;
import com.company.model.Bread;
import com.company.service.api.BeetleService;
import com.company.util.RandomUtil;

import java.util.List;

public class BeetleServiceImpl extends AbstractService<Beetle, BeetleDao> implements BeetleService {

    private final BeetleDao beetleDao;
    private final BreadDao breadDao;

    public BeetleServiceImpl(BeetleDao beetleDao, BreadDao breadDao) {
        super(beetleDao);
        this.beetleDao = beetleDao;
        this.breadDao = breadDao;
    }

    @Override
    public List<Beetle> getAllSortedBy(String columnName) {
        if ("name".equals(columnName)) {
            return beetleDao.getAllSortedByName();
        } else if ("legsCount".equals(columnName)) {
            return beetleDao.getAllSortedByLegsCount();
        } else if ("color".equals(columnName)) {
            return beetleDao.getAllSortedByColor();
        }

        return null;
    }

    @Override
    public String eatBread(Long beetleId, Long breadId) {
        Beetle beetle = beetleDao.getById(beetleId);
        Bread bread = breadDao.getById(breadId);

        if (Math.random() > 0.5) {
            return "Жук " + beetle.getName() + " подорвался на мине (хлебушке)!";
        } else {
            breadDao.delete(breadId);
            int numberOfClones = RandomUtil.randomInt(0, 5);
            for (int i = 0; i < numberOfClones; i++) {
                Beetle cloneBeetle = new Beetle(beetle);
                cloneBeetle.setName(cloneBeetle.getName() + i);
                beetleDao.save(cloneBeetle);
            }
            return "Жук " + beetle.getName() + "скушал хлеб и размножился! Теперь у него личная армия!";
        }
    }
}
