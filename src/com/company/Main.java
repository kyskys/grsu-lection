package com.company;

import com.company.dao.api.BeetleDao;
import com.company.dao.api.BreadDao;
import com.company.dao.api.FrenchmanDao;
import com.company.dao.impl.BeetleDaoImpl;
import com.company.dao.impl.BreadDaoImpl;
import com.company.dao.impl.FrenchmanDaoImpl;
import com.company.model.Beetle;
import com.company.model.Bread;
import com.company.model.FlourType;
import com.company.model.Frenchman;
import com.company.service.api.BeetleService;
import com.company.service.api.BreadService;
import com.company.service.api.FrenchmanService;
import com.company.service.impl.BeetleServiceImpl;
import com.company.service.impl.BreadServiceImpl;
import com.company.service.impl.FrenchmanServiceImpl;

import java.awt.*;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        BeetleDao beetleDao = BeetleDaoImpl.getInstance();
        FrenchmanDao frenchmanDao = FrenchmanDaoImpl.getInstance();
        BreadDao breadDao = BreadDaoImpl.getInstance();

        BeetleService beetleService = new BeetleServiceImpl(beetleDao, breadDao);
        FrenchmanService frenchmanService = new FrenchmanServiceImpl(frenchmanDao, beetleDao, breadDao);
        BreadService breadService = new BreadServiceImpl(breadDao);

        Beetle beetle = new Beetle("Василий", 6, Color.BLUE);
        Beetle beetle2 = new Beetle("Виктор", 4, Color.CYAN);
        Beetle beetle1 = new Beetle("Никита", 2, Color.BLACK);
        Beetle beetle3 = new Beetle("Женька", 50, Color.GRAY);

        Frenchman frenchman = new Frenchman(false, "Пьер", 35);
        Frenchman frenchman1 = new Frenchman(true, "Шарль", 50);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Bread bread = new Bread(FlourType.QQROOZA,
                LocalDate.parse("2021-09-01"), 10, false);
        Bread bread1 = new Bread(FlourType.RICE,
                LocalDate.parse("2021-10-10"), 10, true);

        beetleService.save(beetle);
        beetleService.save(beetle2);
        beetleService.save(beetle1);
        beetleService.save(beetle3);
        frenchmanService.save(frenchman);
        frenchmanService.save(frenchman1);
        breadService.save(bread);
        breadService.save(bread1);

        System.out.println("все жуки");
        System.out.println(beetleService.getAll());
        System.out.println("все французы");
        System.out.println(frenchmanService.getAll());
        System.out.println("все хлебушки");
        System.out.println(breadService.getAll());
        System.out.println();
        System.out.println("все жуки отсортированы по имени");
        System.out.println(beetleService.getAllSortedBy("name"));
        System.out.println("все жуки отсортированы по количеству ног");
        System.out.println(beetleService.getAllSortedBy("legsCount"));
        System.out.println();

        System.out.println(frenchmanService.stompBeetle(frenchman.getId(), beetle.getId()));
        System.out.println(frenchmanService.stompBeetle(frenchman1.getId(), beetle1.getId()));

        System.out.println("все жуки");
        System.out.println(beetleService.getAll());

        System.out.println(frenchmanService.eatBread(frenchman1.getId(), bread.getId()));
        System.out.println(frenchmanService.eatBread(frenchman.getId(), bread.getId()));
        System.out.println("все хлебушки");
        System.out.println(breadService.getAll());

    }
}
