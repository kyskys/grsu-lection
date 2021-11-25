package grsu.lection.start;

import grsu.lection.model.Beetle;
import grsu.lection.model.Bread;
import grsu.lection.model.FlourType;
import grsu.lection.model.Frenchman;
import grsu.lection.service.api.BeetleService;
import grsu.lection.service.api.BreadService;
import grsu.lection.service.api.FrenchmanService;
import grsu.lection.service.impl.BeetleServiceImpl;
import grsu.lection.service.impl.BreadServiceImpl;
import grsu.lection.service.impl.FrenchmanServiceImpl;
import org.springframework.context.ApplicationContext;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConsoleApp {
    
    public static void run(ApplicationContext context) {

        BeetleService beetleService = context.getBean(BeetleService.class);
        FrenchmanService frenchmanService = context.getBean(FrenchmanService.class);
        BreadService breadService = context.getBean(BreadService.class);

        Beetle beetle = Beetle.builder()
                .name("Василий")
                .color("BLUE")
                .legsCount(6)
                .build();

        Frenchman frenchman = new Frenchman(false, "Пьер", 35);
        Frenchman frenchman1 = new Frenchman(true, "Шарль", 50);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Bread bread = new Bread(FlourType.QQROOZA,
                LocalDate.parse("2021-09-01"), 10, false);
        Bread bread1 = new Bread(FlourType.RICE,
                LocalDate.parse("2021-10-10"), 10, true);

//        beetleService.save(beetle);
//        beetleService.save(beetle2);
//        beetleService.save(beetle1);
//        beetleService.save(beetle3);
//        frenchmanService.save(frenchman);
//        frenchmanService.save(frenchman1);
//        breadService.save(bread);
//        breadService.save(bread1);
//
//        System.out.println("все жуки");
//        System.out.println(beetleService.getAll());
//        System.out.println("все французы");
//        System.out.println(frenchmanService.getAll());
//        System.out.println("все хлебушки");
//        System.out.println(breadService.getAll());
//        System.out.println();
//        System.out.println("все жуки отсортированы по имени");
//        System.out.println(beetleService.getAllSortedBy("name"));
//        System.out.println("все жуки отсортированы по количеству ног");
//        System.out.println(beetleService.getAllSortedBy("legsCount"));
//        System.out.println();
//
//        System.out.println(frenchmanService.stompBeetle(frenchman.getId(), beetle.getId()));
//        System.out.println(frenchmanService.stompBeetle(frenchman1.getId(), beetle1.getId()));
//
//        System.out.println("все жуки");
//        System.out.println(beetleService.getAll());
//
//        System.out.println(frenchmanService.eatBread(frenchman1.getId(), bread.getId()));
//        System.out.println(frenchmanService.eatBread(frenchman.getId(), bread.getId()));
//        System.out.println("все хлебушки");
//        System.out.println(breadService.getAll());
    }
}
