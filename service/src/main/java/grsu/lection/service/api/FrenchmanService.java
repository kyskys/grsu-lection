package grsu.lection.service.api;

import grsu.lection.model.Frenchman;

public interface FrenchmanService {

    String stompBeetle(Long frenchId, Long beetleId);

    String eatBread(Long frenchId, Long breadId);
}
