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

        Beetle beetle = new Beetle("Василий", 6, Color.BLUE);
        Beetle beetle2 = new Beetle("Виктор", 4, Color.CYAN);
        Beetle beetle1 = new Beetle("Никита", 2, Color.BLACK);
        Beetle beetle3 = new Beetle("Женька", 50, Color.GRAY);

        beetleService.save(beetle);
        beetleService.save(beetle2);
        beetleService.save(beetle1);
        beetleService.save(beetle3);

        System.out.println(beetleService.getAll());
        System.out.println(beetleService.getAllSortedBy("name"));
        System.out.println(beetleService.getAllSortedBy("legsCount"));

    }
}
