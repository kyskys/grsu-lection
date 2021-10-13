package com.company.service.api;

import com.company.model.Beetle;

public interface BeetleService extends Service<Beetle> {
    String eatBread(Long beetleId, Long breadId);
}
