package com.company.dao.api;

import com.company.model.Beetle;

import java.util.List;

public interface BeetleDao extends Dao<Beetle> {
    List<Beetle> getAllSortedByName();
    List<Beetle> getAllSortedByLegsCount();
    List<Beetle> getAllSortedByColor();
}
