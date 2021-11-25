package grsu.lection.dao.api;

import grsu.lection.dao.filter.BeetleSearch;
import grsu.lection.model.Beetle;

import java.util.List;

public interface BeetleDao extends Dao<Beetle> {
    List<Beetle> getAllSortedByName();
    List<Beetle> getAllSortedByLegsCount();
    List<Beetle> getAllSortedByColor();
    List<Beetle> findAllByName(String name);
    List<Beetle> search(Integer size, Integer page, BeetleSearch search);
}
