package com.company.service.api;

import com.company.model.Frenchman;

public interface FrenchmanService extends Service<Frenchman> {

    String stompBeetle(Long frenchId, Long beetleId);

    String eatBread(Long frenchId, Long breadId);
}
