package com.company;

import com.company.dao.api.BeetleDao;
import com.company.dao.api.BreadDao;
import com.company.dao.api.FrenchmanDao;
import com.company.dao.impl.BeetleDaoImpl;
import com.company.dao.impl.BreadDaoImpl;
import com.company.dao.impl.FrenchmanDaoImpl;
import com.company.model.Beetle;
import com.company.service.api.BeetleService;
import com.company.service.impl.BeetleServiceImpl;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BeetleDao beetleDao = BeetleDaoImpl.getInstance();
        FrenchmanDao frenchmanDao = FrenchmanDaoImpl.getInstance();
        BreadDao breadDao = BreadDaoImpl.getInstance();

        BeetleService beetleService = new BeetleServiceImpl(beetleDao);

        Beetle beetle = new Beetle("jyk", 6, Color.BLUE);

        beetleService.save(beetle);

        System.out.println(beetleDao.getById(0L));

    }
}
