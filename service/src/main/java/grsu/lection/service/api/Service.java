package grsu.lection.service.api;

import grsu.lection.model.AbstractEntity;
import grsu.lection.service.dto.AbstractDto;

import java.util.List;

public interface Service<T extends AbstractEntity, Z extends AbstractDto> {
    void save(Z entity);
    void update(Z entity);
    void delete(Long id);
    Z getById(Long id);
    List<Z> getAll();
    List<Z> getAllSortedBy(String name);
}
