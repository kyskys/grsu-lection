package grsu.lection.service.api;


import grsu.lection.model.Beetle;

public interface BeetleService extends Service<Beetle> {
    String eatBread(Long beetleId, Long breadId);
}
